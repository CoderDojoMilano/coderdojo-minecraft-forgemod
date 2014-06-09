package tutorialMod;

/* Basic importing */


import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/* Basic needed forge stuff: registriamo la mod con Forge */

 //ID della mod - nome della mod - versione della mod
@Mod(modid = CoderdojomiMod.modid, name = "Coderdojomi Mod", version = "1.0")

// solo il client deve aver installato la mod, sul server no
@NetworkMod(clientSideRequired = true, serverSideRequired = false) 

public class CoderdojomiMod {
	public static final String modid = "Coderdojomi_Mod";
	public static Block coderdojomiBlock;
	
	public static Item coderdojomiItem; 
	public static Item coderdojomiSword;

	private EnumToolMaterial coderdojomiToolMaterial;

	@EventHandler
    public void load(FMLInitializationEvent event) {
		//int harvestLevel, int maxUses, float efficiency, float damage, int enchantability
    	coderdojomiToolMaterial = EnumHelper.addToolMaterial("CoderdojomiToolMaterial", 3, 20, 9.0F, 3.5F, 15);
    	
    	coderdojomiItem = new CoderdojomiItem(5000).setUnlocalizedName("coderdojomiItem");
    	coderdojomiSword = new CoderdojomiSword(5001, coderdojomiToolMaterial).setUnlocalizedName("coderdojomiSword");
    	coderdojomiBlock = new CoderdojomiBlock(500, Material.rock).setUnlocalizedName("coderdojomiBlock");
    	
    	LanguageRegistry.addName(coderdojomiItem, "Coderdojomi Item");
    	LanguageRegistry.addName(coderdojomiSword, "Coderdojomi Sword");
    	LanguageRegistry.addName(coderdojomiBlock, "Coderdojomi Block");
    	
    	CoderdojomiCrafting.addRecipes();

    	GameRegistry.registerWorldGenerator(new CoderdojoWorldGenerator());
    	GameRegistry.registerItem(coderdojomiSword, coderdojomiSword.getUnlocalizedName());
    	GameRegistry.registerItem(coderdojomiItem, coderdojomiItem.getUnlocalizedName());
    	GameRegistry.registerBlock(coderdojomiBlock, modid + coderdojomiBlock.getUnlocalizedName().substring(5));
    	
    	FurnaceRecipes.smelting().addSmelting(coderdojomiItem.itemID, new ItemStack(coderdojomiBlock), 0.1f);
    }  
}
