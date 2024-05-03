package io.kalishak.metalcore.api.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.kalishak.metalcore.component.MetalcoreComponents;
import io.kalishak.metalcore.tags.MetalItemTags;
import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.level.block.WeatheringCopper;

import java.util.function.Consumer;

public record WeatheredComponent(WeatheringCopper.WeatherState age, boolean showInTooltip) implements TooltipProvider {
    private static final Codec<WeatheredComponent> FULL_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            WeatheringCopper.WeatherState.CODEC.fieldOf("weather_state").forGetter(WeatheredComponent::age),
            Codec.BOOL.fieldOf("show_in_tooltip").forGetter(WeatheredComponent::showInTooltip)
    ).apply(instance, WeatheredComponent::new));
    public static final Codec<WeatheredComponent> CODEC = Codec.withAlternative(FULL_CODEC, WeatheringCopper.WeatherState.CODEC, weatherState1 -> new WeatheredComponent(weatherState1, true));
    public static final StreamCodec<ByteBuf, WeatheredComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(WeatheringCopper.WeatherState.CODEC), WeatheredComponent::age,
            ByteBufCodecs.BOOL, WeatheredComponent::showInTooltip,
            WeatheredComponent::new);

    public static WeatheringCopper.WeatherState getOrDefault(ItemStack stack, WeatheringCopper.WeatherState defaultValue) {
        WeatheredComponent weatheredCopperItem = stack.get(MetalcoreComponents.WEATHERED_ITEM);
        return weatheredCopperItem == null ? defaultValue : weatheredCopperItem.age;
    }

    public static ItemStack apply(ItemStack stack, WeatheringCopper.WeatherState state) {
        if (!stack.is(MetalItemTags.WEATHERING_ITEM)) {
            return ItemStack.EMPTY;
        } else {
            ItemStack copy = stack.copyWithCount(1);
            WeatheredComponent weatheredCopperItem = copy.get(MetalcoreComponents.WEATHERED_ITEM);
            WeatheringCopper.WeatherState weatherState = weatheredCopperItem != null ? weatheredCopperItem.age : state;
            boolean flag = weatheredCopperItem == null || weatheredCopperItem.showInTooltip();

            copy.set(MetalcoreComponents.WEATHERED_ITEM, new WeatheredComponent(weatherState, flag));
            return copy;
        }
    }

    @Override
    public void addToTooltip(Item.TooltipContext tooltipContext, Consumer<Component> text, TooltipFlag tooltipFlag) {
        if (this.showInTooltip) {
            text.accept(Component.translatable("item.weathered_state." + this.age.getSerializedName()).withStyle(ChatFormatting.ITALIC));
        }
    }

    public WeatheredComponent withTooltip(boolean showInTooltip) {
        return new WeatheredComponent(this.age, showInTooltip);
    }
}
