package io.kalishak.metalcore.world.level.block.pipe;

import com.mojang.serialization.MapCodec;
import io.kalishak.metalcore.api.block.SixwayStorageBlock;
import io.kalishak.metalcore.api.block.ToolActionStateModifable;
import io.kalishak.metalcore.world.level.block.entity.CopperPipeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class CopperPipeBlock extends SixwayStorageBlock<CopperPipeBlockEntity> implements ToolActionStateModifable {
    public CopperPipeBlock(Properties properties) {
        super(Type.ITEM, 1.0D, properties);
    }

    @Override
    protected MapCodec<? extends CopperPipeBlock> codec() {
        return simpleCodec(CopperPipeBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CopperPipeBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        return applyToolAction(state, context, toolAction);
    }
}
