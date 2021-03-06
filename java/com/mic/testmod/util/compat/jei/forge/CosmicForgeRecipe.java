package com.mic.testmod.util.compat.jei.forge;

import java.awt.Color;
import java.util.List;

import com.mic.testmod.blocks.machine.forge.CosmicForgeRecipes;
import com.mic.testmod.util.compat.jei.JEICompat;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;

public class CosmicForgeRecipe implements IRecipeWrapper{

	
	private final List<ItemStack> inputs;
	private final ItemStack output;
	
	
	public CosmicForgeRecipe(List<ItemStack> inputs, ItemStack output){
		this.inputs = inputs;
		this.output = output;
	}


	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
		
	}
	
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		CosmicForgeRecipes recipes = CosmicForgeRecipes.getInstance();
		
		float experience = recipes.getForgeExperience(output);
		
		if(experience > 0){
			String xpString = JEICompat.translateToLocalFromFormatted("gui.jei.category.smelting.experience", experience);
			FontRenderer renderer = minecraft.fontRenderer;
			int stringWidth = renderer.getStringWidth(xpString);
			renderer.drawString(xpString, recipeWidth - stringWidth, 0, Color.gray.getRGB());
			
		}
	}
	
}
