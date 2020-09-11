package com.neocosplayer.hongkongdrinks.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import com.neocosplayer.hongkongdrinks.item.TaoTiMetaGreenTeaItem;
import com.neocosplayer.hongkongdrinks.entity.TaoTiMetaGreenTeaEntityEntity;
import com.neocosplayer.hongkongdrinks.HongkongdrinksModElements;

@HongkongdrinksModElements.ModElement.Tag
public class TaoTiMetaGreenTeaOnFoodRightClickedProcedure extends HongkongdrinksModElements.ModElement {
	public TaoTiMetaGreenTeaOnFoodRightClickedProcedure(HongkongdrinksModElements instance) {
		super(instance, 59);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		Entity entityToSpawn = new TaoTiMetaGreenTeaEntityEntity.CustomEntity(TaoTiMetaGreenTeaEntityEntity.entity, world.getWorld());
		
		if ((((entity.isSneaking()) && (new ItemStack(TaoTiMetaGreenTeaItem.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))
				|| ((new ItemStack(TaoTiMetaGreenTeaItem.block, (int) (1))
						.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem())
						&& (new ItemStack(Blocks.AIR, (int) (1))
								.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getItem())))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory
						.clearMatchingItems(p -> new ItemStack(TaoTiMetaGreenTeaItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);

			DrinkPlaced.place(x, y, z, entity, world, entityToSpawn);
		}
	}
}
