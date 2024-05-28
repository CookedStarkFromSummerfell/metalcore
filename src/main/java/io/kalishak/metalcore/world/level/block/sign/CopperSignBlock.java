package io.kalishak.metalcore.world.level.block.sign;

import com.mojang.serialization.MapCodec;
import io.kalishak.metalcore.api.block.ToolActionStateModifable;
import io.kalishak.metalcore.api.block.state.properties.MetalType;
import io.kalishak.metalcore.world.level.block.entity.CopperSignBlockEntity;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.UUID;

public abstract class CopperSignBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, ToolActionStateModifable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final float AABB_OFFSET = 4.0F;
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private final MetalType type;

    protected CopperSignBlock(MetalType type, BlockBehaviour.Properties properties) {
        super(properties);
        this.type = type;
    }

    @Override
    protected abstract MapCodec<? extends CopperSignBlock> codec();

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isPossibleToRespawnInThis(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperSignBlockEntity(pos, state);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.getBlockEntity(pos) instanceof CopperSignBlockEntity sign) {
            SignApplicator signApplicator = stack.getItem() instanceof SignApplicator signApplicator1 ? signApplicator1 : null;
            boolean flag = signApplicator != null && player.mayBuild();

            if (!level.isClientSide) {
                if (flag && !sign.isWaxed() && !otherPlayerIsEditingSign(player, sign)) {
                    boolean facingText = sign.isFacingFrontText(player);

                    if (signApplicator.canApplyToSign(sign.getText(facingText), player) && signApplicator.tryApplyToSign(level, sign, facingText, player)) {
                        sign.executeClickCommandsIfPresent(player, level, pos, facingText);
                        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                        level.gameEvent(GameEvent.BLOCK_CHANGE, sign.getBlockPos(), GameEvent.Context.of(player, sign.getBlockState()));

                        if (!player.isCreative()) {
                            stack.shrink(1);

                        }

                        return ItemInteractionResult.SUCCESS;
                    } else {
                        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                    }
                } else {
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                }
            } else {
                return !flag && !sign.isWaxed() ? ItemInteractionResult.CONSUME : ItemInteractionResult.SUCCESS;
            }
        } else {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos pos, Player player, BlockHitResult result) {
        if (level.getBlockEntity(pos) instanceof CopperSignBlockEntity sign) {
            if (level.isClientSide) {
                Util.pauseInIde(new IllegalStateException("Expected to only call this on server"));
            }

            boolean isFacingText = sign.isFacingFrontText(player);
            boolean executes = sign.executeClickCommandsIfPresent(player, level, pos, isFacingText);

            if (sign.isWaxed()) {
                level.playSound(null, sign.getBlockPos(), sign.getSignInteractionFailedSoundEvent(), SoundSource.BLOCKS);
                return InteractionResult.SUCCESS;
            } else if (!executes) {
                return InteractionResult.SUCCESS;
            } else if (!otherPlayerIsEditingSign(player, sign) && player.mayBuild() && hasEditableText(player, sign, isFacingText)) {
                openTextEdit(player, sign, isFacingText);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        }

        return InteractionResult.PASS;
    }

    private boolean hasEditableText(Player player, CopperSignBlockEntity sign, boolean isFrontText) {
        SignText signtext = sign.getText(isFrontText);
        return Arrays.stream(signtext.getMessages(player.isTextFilteringEnabled()))
                .allMatch(component -> component.equals(CommonComponents.EMPTY) || component.getContents() instanceof PlainTextContents);
    }

    public abstract float getYRotationDegrees(BlockState state);

    public Vec3 getSignHitboxCenterPosition(BlockState state) {
        return new Vec3(0.5, 0.5, 0.5);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public MetalType getType() {
        return this.type;
    }

    public static MetalType getMetalType(Block block) {
        MetalType type;

        if (block instanceof CopperSignBlock signBlock) {
            type = signBlock.getType();
        } else {
            type = MetalType.values().findFirst().orElseThrow();
        }

        return type;
    }

    public void openTextEdit(Player player, CopperSignBlockEntity sign, boolean isFrontText) {
        sign.setAllowedPlayerEditor(player.getUUID());
        player.openTextEdit(sign, isFrontText);
    }

    private boolean otherPlayerIsEditingSign(Player player, CopperSignBlockEntity sign) {
        UUID uuid = sign.getPlayerWhoMayEdit();
        return uuid != null && !uuid.equals(player.getUUID());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, MetalcoreBlockEntityType.COPPER_SIGN.get(), CopperSignBlockEntity::tick);
    }
}
