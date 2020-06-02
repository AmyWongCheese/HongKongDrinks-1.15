package net.mcreator.hongkongdrinks.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.hongkongdrinks.item.VitaMaltSoyaMilkItem;
import net.mcreator.hongkongdrinks.entity.VitaMaltSoyaMilkEntityEntity;
import net.mcreator.hongkongdrinks.HongkongdrinksModElements;

@HongkongdrinksModElements.ModElement.Tag
public class VitaMaltSoyaMilkOnFoodRightClickedProcedure extends HongkongdrinksModElements.ModElement {
	public VitaMaltSoyaMilkOnFoodRightClickedProcedure(HongkongdrinksModElements instance) {
		super(instance, 115);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VitaMaltSoyaMilkOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure VitaMaltSoyaMilkOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure VitaMaltSoyaMilkOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure VitaMaltSoyaMilkOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VitaMaltSoyaMilkOnFoodRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		float x = (float) entity.getPosX();
		float y = (float) entity.getPosY();
		float z = (float) entity.getPosZ();
		World world = (World) dependencies.get("world");
		if ((((entity.isSneaking()) && (new ItemStack(VitaMaltSoyaMilkItem.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))
				|| ((new ItemStack(VitaMaltSoyaMilkItem.block, (int) (1))
						.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem())
						&& (new ItemStack(Blocks.AIR, (int) (1))
								.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getItem())))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory
						.clearMatchingItems(p -> new ItemStack(VitaMaltSoyaMilkItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			world.playSound((PlayerEntity) null, x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.place")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
			if (((entity.getHorizontalFacing()) == Direction.NORTH)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new VitaMaltSoyaMilkEntityEntity.CustomEntity(VitaMaltSoyaMilkEntityEntity.entity, world);
					entityToSpawn.setLocationAndAngles((x), (y + 1), (z - 1), world.rand.nextFloat() * 360F, 0.0F);
					world.addEntity(entityToSpawn);
				}
			} else if (((entity.getHorizontalFacing()) == Direction.SOUTH)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new VitaMaltSoyaMilkEntityEntity.CustomEntity(VitaMaltSoyaMilkEntityEntity.entity, world);
					entityToSpawn.setLocationAndAngles((x), (y + 1), (z + 1), world.rand.nextFloat() * 360F, 0.0F);
					world.addEntity(entityToSpawn);
				}
			} else if (((entity.getHorizontalFacing()) == Direction.EAST)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new VitaMaltSoyaMilkEntityEntity.CustomEntity(VitaMaltSoyaMilkEntityEntity.entity, world);
					entityToSpawn.setLocationAndAngles((x + 1), (y + 1), (z), world.rand.nextFloat() * 360F, 0.0F);
					world.addEntity(entityToSpawn);
				}
			} else if (((entity.getHorizontalFacing()) == Direction.WEST)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new VitaMaltSoyaMilkEntityEntity.CustomEntity(VitaMaltSoyaMilkEntityEntity.entity, world);
					entityToSpawn.setLocationAndAngles((x - 1), (y + 1), (z), world.rand.nextFloat() * 360F, 0.0F);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
