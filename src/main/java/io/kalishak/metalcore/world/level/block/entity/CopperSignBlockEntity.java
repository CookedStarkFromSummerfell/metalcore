package io.kalishak.metalcore.world.level.block.entity;

import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.world.level.block.sign.CopperSignBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;

public class CopperSignBlockEntity extends SignBlockEntity {
    public CopperSignBlockEntity(BlockPos pos, BlockState state) {
        super(MetalcoreBlockEntityType.COPPER_SIGN.get(), pos, state);
    }

    public CopperSignBlockEntity(BlockEntityType<? extends CopperSignBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CopperSignBlockEntity sign) {
        UUID uuid = sign.getPlayerWhoMayEdit();
        if (uuid != null) {
            sign.clearInvalidPlayerWhoMayEdit(sign, level, uuid);
        }

        if (!level.isClientSide && state.getBlock() instanceof WeatheringCopperHolder weatheringBlock && !sign.isWaxed()) {
            ServerLevel serverLevel = (ServerLevel) level;
            weatheringBlock.changeOverTime(state, serverLevel, pos, serverLevel.random);
        }
    }

    @Override
    public boolean isFacingFrontText(Player player) {
        if (this.getBlockState().getBlock() instanceof CopperSignBlock signblock) {
            Vec3 vec3 = signblock.getSignHitboxCenterPosition(this.getBlockState());
            double d0 = player.getX() - ((double)this.getBlockPos().getX() + vec3.x);
            double d1 = player.getZ() - ((double)this.getBlockPos().getZ() + vec3.z);
            float f = signblock.getYRotationDegrees(this.getBlockState());
            float f1 = (float)(Mth.atan2(d1, d0) * 180.0F / (float)Math.PI) - 90.0F;
            return Mth.degreesDifferenceAbs(f, f1) <= 90.0F;
        } else {
            return false;
        }
    }

    private void clearInvalidPlayerWhoMayEdit(SignBlockEntity sign, Level level, UUID uuid) {
        if (sign.playerIsTooFarAwayToEdit(uuid)) {
            sign.setAllowedPlayerEditor(null);
        }
    }
}
