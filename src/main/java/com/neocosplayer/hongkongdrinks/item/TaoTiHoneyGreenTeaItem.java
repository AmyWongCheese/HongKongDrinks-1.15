
package com.neocosplayer.hongkongdrinks.item;

@HongkongdrinksModElements.ModElement.Tag
public class TaoTiHoneyGreenTeaItem extends HongkongdrinksModElements.ModElement {

	@ObjectHolder("hongkongdrinks:tao_ti_honey_green_tea")
	public static final Item block = null;

	public TaoTiHoneyGreenTeaItem(HongkongdrinksModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(HongKongDrinksItemGroup.tab).maxStackSize(64).food((new Food.Builder()).hunger(4).saturation(0.3f)

					.build()));
			setRegistryName("tao_ti_honey_green_tea");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				TaoTiHoneyGreenTeaOnFoodRightClickedProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				VitaLemonTeaFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}
