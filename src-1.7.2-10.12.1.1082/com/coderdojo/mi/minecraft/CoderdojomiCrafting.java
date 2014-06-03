package com.coderdojo.mi.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CoderdojomiCrafting {

	public static void addLetterTRecipe(Block block) {
		GameRegistry.addRecipe(new ItemStack(block), new Object[]
				{
				        	"ZZZ",
				        	" Z ",
				        	" Z ",
				        	'Z', CustomMod.ITEM_ZERO, 
				});
	}

	public static void addLetterORecipe(Block block) {
		GameRegistry.addRecipe(new ItemStack(block), new Object[]
				{
				        	"ZZZ",
				        	"Z Z",
				        	"ZZZ",
				        	'Z', CustomMod.ITEM_ZERO, 
				});
		
	}

}
