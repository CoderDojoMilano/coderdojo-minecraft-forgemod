package tutorialMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = CoderdojomiMod.modid, name = "Coderdojomi Mod", version = "1.0.forge-1.7.10-10.13.2.1232")
public class CoderdojomiMod {

    static final String modid = "coderdojomi_mod";

     /*

	private EventManger eventmanager = new EventManger();
	private Item.ToolMaterial coderdojomiToolMaterial;
	private Item coderdojomiSword;
	private ItemArmor.ArmorMaterial corderdojomiArmorMaterial;
	private Item coderdojomiArmorHelmet;
	private Item coderdojomiArmorPlate;
	private Item coderdojomiArmorLegs;
	private Item coderdojomiArmorBoots;
	public static Item coderdojomiItem; //il mio nuovo Item
	//
	*/



    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        final Item diamondItem = GameData.getItemRegistry().getObject("diamond");
        final Block coderdojomiBlock = 	new CoderdojomiBlock( Material.rock, "Coder Dojo Block !")
        					.setTopBlockTextureName(modid + ":zero-one")
        					.setBottomBlockTextureName(modid + ":blue")
        					.setNorthBlockTextureName(modid + ":green")
					        .setEastBlockTextureName(modid + ":red")
        					.setSouthBlockTextureName(modid + ":orange")
					        .setWestBlockTextureName(modid + ":purple")
					        .setQuantityDropped(4)
					        .setItemDropped(diamondItem)
					        //.setBlockUnbreakable() //This method will set the hardness of the block to -1, making it indestructible 
					        .setHardness(1.0F) //Sets how many hits it takes to break a block
					        .setStepSound(Block.soundTypeGlass) //Sets the footstep sound for the block.
					        .setCreativeTab(CreativeTabs.tabFood)
					        ;
        final CoderdojomiWorldGenerator coderDojomiWorldGenerator = new CoderdojomiWorldGenerator(coderdojomiBlock);
        
        GameRegistry.registerBlock(coderdojomiBlock, coderdojomiBlock.getUnlocalizedName());
        
        GameRegistry.registerWorldGenerator(coderDojomiWorldGenerator, 10); //min weight -> starts firts

        /*
        //int harvestLevel, int maxUses, float efficiency, float damage, int enchantability
        coderdojomiToolMaterial = EnumHelper.addToolMaterial("CoderdojomiToolMaterial", 3, 20, 9.0F, 3.5F, 15);

        coderdojomiItem = new CoderdojomiItem().setUnlocalizedName("coderdojomiItem");
        LanguageRegistry.addName(coderdojomiItem, "Coderdojomi Item");


    	GameRegistry.registerBlock(coderdojomiBlock, modid + coderdojomiBlock.getUnlocalizedName().substring(5));

    	LanguageRegistry.addName(coderdojomiBlock, "Coderdojomi Block");

    	CoderdojomiCrafting.addRecipes();

    	//GameRegistry.registerWorldGenerator(eventmanager);
    	//GameRegistry.registerWorldGenerator(new CoderdojoWorldGenerator());


    	//FurnaceRecipes.smelting().addSmelting(coderdojomiItem.itemID, new ItemStack(coderdojomiBlock), 0.1f);

    	coderdojomiSword = new CoderdojomiSword( coderdojomiToolMaterial).setUnlocalizedName("coderdojomiSword");
    	LanguageRegistry.addName(coderdojomiSword, "Coderdojomi Sword");
    	GameRegistry.registerItem(coderdojomiSword, coderdojomiSword.getUnlocalizedName());

    	//durability, reductionAmounts, enchantability
    	corderdojomiArmorMaterial = EnumHelper.addArmorMaterial("CoderdojomiArmorMaterial", 33, new int[]{3, 8, 6, 3}, 10);

    	coderdojomiArmorHelmet = new CoderdojomiArmorItem(corderdojomiArmorMaterial, 1, 0, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_helmet");
    	coderdojomiArmorPlate = new CoderdojomiArmorItem(corderdojomiArmorMaterial, 1, 1, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_chestplate");
    	coderdojomiArmorLegs = new CoderdojomiArmorItem(corderdojomiArmorMaterial, 1, 2, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_leggings");
    	coderdojomiArmorBoots = new CoderdojomiArmorItem(corderdojomiArmorMaterial, 1, 3, CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer.png").setUnlocalizedName("coderdojomi_boots");

    	LanguageRegistry.addName(coderdojomiArmorHelmet, "Coderdojomi Armor Helmet");
    	LanguageRegistry.addName(coderdojomiArmorPlate, "Coderdojomi Armor Plate");
    	LanguageRegistry.addName(coderdojomiArmorLegs, "Coderdojomi Armor Legs");
    	LanguageRegistry.addName(coderdojomiArmorBoots, "Coderdojomi Armor Boots");
    	GameRegistry.registerItem(coderdojomiArmorHelmet, coderdojomiArmorHelmet.getUnlocalizedName());
    	GameRegistry.registerItem(coderdojomiArmorPlate, coderdojomiArmorPlate.getUnlocalizedName());
    	GameRegistry.registerItem(coderdojomiArmorLegs, coderdojomiArmorLegs.getUnlocalizedName());
    	GameRegistry.registerItem(coderdojomiArmorBoots, coderdojomiArmorBoots.getUnlocalizedName());
    	*/
    }
}
