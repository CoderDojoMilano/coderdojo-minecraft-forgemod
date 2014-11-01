package tutorialMod;

/* Basic importing */


import net.minecraft.item.EnumArmorMaterial;
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
	
	private EventManger eventmanager = new EventManger();
	private EnumToolMaterial coderdojomiToolMaterial;
	private Item coderdojomiSword;
	private EnumArmorMaterial corderdojomiArmorMaterial;
	private Item coderdojomiArmorHelmet;
	private Item coderdojomiArmorPlate;
	private Item coderdojomiArmorLegs;
	private Item coderdojomiArmorBoots;
	public static Item coderdojomiItem; //il mio nuovo Item

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
		//int harvestLevel, int maxUses, float efficiency, float damage, int enchantability
    	coderdojomiToolMaterial = EnumHelper.addToolMaterial("CoderdojomiToolMaterial", 3, 20, 9.0F, 3.5F, 15);
    	
    	 coderdojomiItem = new CoderdojomiItem(5000).setUnlocalizedName("coderdojomiItem");
    	 LanguageRegistry.addName(coderdojomiItem, "Coderdojomi Item");

    	coderdojomiBlock = new CoderdojomiBlock(500, Material.rock).setUnlocalizedName("coderdojomiBlock");
    	
    	GameRegistry.registerBlock(coderdojomiBlock, modid + coderdojomiBlock.getUnlocalizedName().substring(5));
        
    	LanguageRegistry.addName(coderdojomiBlock, "Coderdojomi Block");
    	
    	CoderdojomiCrafting.addRecipes();

    	//GameRegistry.registerWorldGenerator(eventmanager);
    	GameRegistry.registerWorldGenerator(new CoderdojoWorldGenerator());

    	
    	FurnaceRecipes.smelting().addSmelting(coderdojomiItem.itemID, new ItemStack(coderdojomiBlock), 0.1f);
    	
    	coderdojomiSword = new CoderdojomiSword(5001, coderdojomiToolMaterial).setUnlocalizedName("coderdojomiSword");
    	LanguageRegistry.addName(coderdojomiSword, "Coderdojomi Sword");
    	GameRegistry.registerItem(coderdojomiSword, coderdojomiSword.getUnlocalizedName());
    	
    	//durability, reductionAmounts, enchantability
    	corderdojomiArmorMaterial = EnumHelper.addArmorMaterial("CoderdojomiArmorMaterial", 33, new int[]{3, 8, 6, 3}, 10);
    	
    	coderdojomiArmorHelmet = new CoderdojomiArmorItem(5002, corderdojomiArmorMaterial, 0, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_helmet");
    	coderdojomiArmorPlate = new CoderdojomiArmorItem(5003, corderdojomiArmorMaterial, 1, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_chestplate");
    	coderdojomiArmorLegs = new CoderdojomiArmorItem(5004, corderdojomiArmorMaterial, 2, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_leggings");
    	coderdojomiArmorBoots = new CoderdojomiArmorItem(5005, corderdojomiArmorMaterial, 3, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_boots");

    	LanguageRegistry.addName(coderdojomiArmorHelmet, "Coderdojomi Armor Helmet");
    	LanguageRegistry.addName(coderdojomiArmorPlate, "Coderdojomi Armor Plate");
    	LanguageRegistry.addName(coderdojomiArmorLegs, "Coderdojomi Armor Legs");
    	LanguageRegistry.addName(coderdojomiArmorBoots, "Coderdojomi Armor Boots");
    	GameRegistry.registerItem(coderdojomiArmorHelmet, coderdojomiArmorHelmet.getUnlocalizedName());
    	GameRegistry.registerItem(coderdojomiArmorPlate, coderdojomiArmorPlate.getUnlocalizedName());
    	GameRegistry.registerItem(coderdojomiArmorLegs, coderdojomiArmorLegs.getUnlocalizedName());
    	GameRegistry.registerItem(coderdojomiArmorBoots, coderdojomiArmorBoots.getUnlocalizedName());
    }  
}
