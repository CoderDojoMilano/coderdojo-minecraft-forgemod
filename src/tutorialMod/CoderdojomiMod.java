package tutorialMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CoderdojomiMod.modid, name = "Coderdojomi Mod", version = "1.0.forge-1.7.10-10.13.2.1232")
public class CoderdojomiMod {

    static final String modid = "coderdojomi_mod";

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	//definition
        final Item diamondItem = Items.diamond;
        
        final Block coderdojomiBlock = 	new CoderdojomiBlock( Material.rock, "coderdojomiblock")
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
        
        final Item coderdojomiItem = 
        		new CoderdojomiItem("coderdojomiitem")
        		.setIconName(modid + ":zero")
        		;
        
        final CoderdojomiWorldGenerator coderDojomiWorldGenerator = new CoderdojomiWorldGenerator(coderdojomiBlock);

        //int harvestLevel, int maxUses, float efficiency, float damage, int enchantability
        ToolMaterial toolMaterial = EnumHelper.addToolMaterial("coderdojomiToolMaterial", 3, 20, 9.0F, 3.5F, 15);
        final CoderdojomiSword coderdojomiSword = 
        		new CoderdojomiSword( toolMaterial, "coderdojomisword")
        		.setIconName(modid + ":sword")
        		;
        
        //durability, reductionAmounts, enchantability
    	ArmorMaterial armorMaterial = EnumHelper.addArmorMaterial("coderdojomiArmorMaterial", 33, new int[]{3, 8, 6, 3}, 10);

    	Item helmet = new CoderdojomiArmorItem(armorMaterial, 1, 0, modid + ":" + "model/armor/coderdojomi_layer", "coderdojomi_helmet");
    	Item chest = new CoderdojomiArmorItem(armorMaterial, 1, 1, modid + ":" + "model/armor/coderdojomi_layer", "coderdojomi_chestplate");
    	Item leggings = new CoderdojomiArmorItem(armorMaterial, 1, 2, modid + ":" + "model/armor/coderdojomi_layer", "coderdojomi_leggings");
    	Item boots = new CoderdojomiArmorItem(armorMaterial, 1, 3, modid + ":" + "model/armor/coderdojomi_layer", "coderdojomi_boots");
        
        //registration
        GameRegistry.registerItem(coderdojomiSword, coderdojomiSword.getUnlocalizedName());

        GameRegistry.registerBlock(coderdojomiBlock, coderdojomiBlock.getUnlocalizedName());
        
        GameRegistry.registerWorldGenerator(coderDojomiWorldGenerator, 10); //min weight -> starts firts

		GameRegistry.addRecipe(new ItemStack(coderdojomiBlock), new Object[]{
			"A  ",
			" A ",
			"  A",
			'A', new ItemStack(diamondItem)
		});
		
		GameRegistry.registerItem(coderdojomiItem, coderdojomiItem.getUnlocalizedName());

		FurnaceRecipes.smelting().func_151396_a(diamondItem, new ItemStack(coderdojomiItem), 0.5F);

		GameRegistry.registerItem(helmet, helmet.getUnlocalizedName());
		GameRegistry.registerItem(chest, chest.getUnlocalizedName());
		GameRegistry.registerItem(leggings, leggings.getUnlocalizedName());
		GameRegistry.registerItem(boots, boots.getUnlocalizedName());
    }
}
