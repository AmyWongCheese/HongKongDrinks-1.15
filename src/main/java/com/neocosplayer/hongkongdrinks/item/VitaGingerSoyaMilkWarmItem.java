
package com.neocosplayer.hongkongdrinks.item;

@HongkongdrinksModElements.ModElement.Tag
public class VitaGingerSoyaMilkWarmItem extends HongkongdrinksModElements.ModElement {

	@ObjectHolder("hongkongdrinks:vita_ginger_soya_milk_warm")
	public static final Item block = null;

	public VitaGingerSoyaMilkWarmItem(HongkongdrinksModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(HongKongDrinksItemGroup.tab).maxStackSize(64).food((new Food.Builder()).hunger(4).saturation(0.3f)

					.build()));
			setRegistryName("vita_ginger_soya_milk_warm");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
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
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				VitaGingerSoyaMilkWarmFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}
