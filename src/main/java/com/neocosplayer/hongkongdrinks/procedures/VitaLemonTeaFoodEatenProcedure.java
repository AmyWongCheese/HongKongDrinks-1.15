package com.neocosplayer.hongkongdrinks.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.neocosplayer.hongkongdrinks.HongkongdrinksModElements;

@HongkongdrinksModElements.ModElement.Tag
public class VitaLemonTeaFoodEatenProcedure extends HongkongdrinksModElements.ModElement {
	public VitaLemonTeaFoodEatenProcedure(HongkongdrinksModElements instance) {
		super(instance, 58);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure VitaLemonTeaFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
	}
}
