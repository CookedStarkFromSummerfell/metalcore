package io.kalishak.metalcore.world.level.block.pipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.api.block.WeatheringCopperHolder;
import io.kalishak.metalcore.world.level.block.entity.CopperPipeBlockEntity;
import io.kalishak.metalcore.world.level.block.entity.MetalcoreBlockEntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WeatheringCopperPipeBlock extends CopperPipeBlock implements WeatheringCopperHolder {
    public static final MapCodec<WeatheringCopperPipeBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperPipeBlock::getAge),
            propertiesCodec()
    ).apply(instance, WeatheringCopperPipeBlock::new));

    protected final WeatherState weatherState;

    public WeatheringCopperPipeBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<? extends WeatheringCopperPipeBlock> codec() {
        return CODEC;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? null : createTickerHelper(pBlockEntityType, MetalcoreBlockEntityType.COPPER_PIPE.get(), CopperPipeBlockEntity::serverTick);
    }
}
