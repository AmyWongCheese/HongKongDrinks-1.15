
package net.mcreator.hongkongdrinks.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.hongkongdrinks.procedures.VitaLemonTeaFoodEatenProcedure;
import net.mcreator.hongkongdrinks.itemgroup.HongKongDrinksItemGroup;
import net.mcreator.hongkongdrinks.HongkongdrinksModElements;

@HongkongdrinksModElements.ModElement.Tag
public class TaoTiHoneyGreenTeaItem extends HongkongdrinksModElements.ModElement {
	@ObjectHolder("hongkongdrinks:tao_ti_honey_green_tea")
	public static final Item block = null;
	public TaoTiHoneyGreenTeaItem(HongkongdrinksModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(HongKongDrinksItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("tao_ti_honey_green_tea");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				VitaLemonTeaFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
