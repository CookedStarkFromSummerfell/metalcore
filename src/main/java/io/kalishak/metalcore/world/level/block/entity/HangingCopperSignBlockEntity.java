package io.kalishak.metalcore.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.BlockState;

public class HangingCopperSignBlockEntity extends CopperSignBlockEntity {
    private static final int MAX_TEXT_LINE_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;

    public HangingCopperSignBlockEntity(BlockPos pos, BlockState state) {
        super(MetalcoreBlockEntityType.HANGING_COPPER_SIGN.get(), pos, state);
    }

    @Override
    public int getTextLineHeight() {
        return TEXT_LINE_HEIGHT;
    }

    @Override
    public int getMaxTextLineWidth() {
        return MAX_TEXT_LINE_WIDTH;
    }

    @Override
    public SoundEvent getSignInteractionFailedSoundEvent() {
        return SoundEvents.WAXED_HANGING_SIGN_INTERACT_FAIL;
    }
}
