package tutorialMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CoderdojomiCrafting {

	public static void addFirstRecipes(Block block) {
		 GameRegistry.addRecipe(new ItemStack(block), new Object[]
					{
					        	"ZZ ",
					        	"ZSX",
					        	" XX",
					        	'X', Item.coal, 
					        	'S', BlockFlower.plantYellow, 
					        	'Z', Item.sugar
					});
		
	}

}
