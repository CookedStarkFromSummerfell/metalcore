package io.kalishak.metalcore.world.item;

import io.kalishak.metalcore.world.entity.CopperBoat;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class CopperBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.or(Entity::isPickable);
    private final CopperBoat.Type type;
    private final boolean waxed;

    public CopperBoatItem(boolean waxed, CopperBoat.Type type, Item.Properties properties) {
        super(properties);
        this.waxed = waxed;
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        HitResult hitResult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.ANY);

        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(stack);
        } else {
            Vec3 vec3 = pPlayer.getViewVector(1.0F);
            List<Entity> list = pLevel.getEntities(pPlayer, pPlayer.getBoundingBox().expandTowards(vec3.scale(5.0D)), ENTITY_PREDICATE);

            if (!list.isEmpty()) {
                Vec3 vec31 = pPlayer.getEyePosition();

                for (Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());

                    if (aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(stack);
                    }
                }
            }

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                CopperBoat copperBoat = getBoat(pLevel, hitResult, stack, pPlayer);
                copperBoat.setVariant(this.type);
                copperBoat.setWaxed(this.waxed);
                copperBoat.setYRot(pPlayer.getYRot());

                if (!pLevel.noCollision(copperBoat, copperBoat.getBoundingBox())) {
                    return InteractionResultHolder.fail(stack);
                } else {
                    if (!pLevel.isClientSide) {
                        pLevel.addFreshEntity(copperBoat);
                        pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, hitResult.getLocation());
                        stack.consume(1, pPlayer);
                    }

                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(stack, pLevel.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(stack);
            }
        }
    }

    protected CopperBoat getBoat(Level level, HitResult hitResult, ItemStack stack, Player player) {
        Vec3 vec3 = hitResult.getLocation();
        CopperBoat copperBoat = new CopperBoat(level, vec3.x, vec3.y, vec3.z);

        if (level instanceof ServerLevel serverLevel) {
            EntityType.<CopperBoat>createDefaultStackConfig(serverLevel, stack, player).accept(copperBoat);
        }

        return copperBoat;
    }
}
