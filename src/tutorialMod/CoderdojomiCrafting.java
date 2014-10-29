package tutorialMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CoderdojomiCrafting {

	public static void addRecipes() {
		 GameRegistry.addRecipe(new ItemStack(CoderdojomiMod.coderdojomiBlock), new Object[]
					{
					        	"ZZ ",
					        	"ZSX",
					        	" XX",
					        	'X', Item.itemRegistry.getObject("coal"), 'S', Item.itemRegistry.getObject("bone"), 'Z', Item.itemRegistry.getObject("sugar")
					});
		
	}

}
