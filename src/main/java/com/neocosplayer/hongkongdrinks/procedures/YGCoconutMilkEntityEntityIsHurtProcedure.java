package com.neocosplayer.hongkongdrinks.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.Map;

import com.neocosplayer.hongkongdrinks.item.YGCoconutMilkItem;
import com.neocosplayer.hongkongdrinks.HongkongdrinksModElements;

@HongkongdrinksModElements.ModElement.Tag
public class YGCoconutMilkEntityEntityIsHurtProcedure extends HongkongdrinksModElements.ModElement {
	public YGCoconutMilkEntityEntityIsHurtProcedure(HongkongdrinksModElements instance) {
		super(instance, 164);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure YGCoconutMilkEntityEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure YGCoconutMilkEntityEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure YGCoconutMilkEntityEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure YGCoconutMilkEntityEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure YGCoconutMilkEntityEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!entity.world.isRemote)
			entity.remove();
		if ((!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)))) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(YGCoconutMilkItem.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
