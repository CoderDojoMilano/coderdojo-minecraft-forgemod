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
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CoderdojomiMod.modid, name = CoderdojomiMod.name, version = "${version}")
public class CoderdojomiMod {

    static final String modid = "coderdojomi_mod";
    static final String name = "${name}";

    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	System.out.println(name);
    	//definition
    	final Item diamondItem = GameData.getItemRegistry().getObject("diamond");
    	
        final Block coderdojomiBlock = 	
        		new CoderdojomiBlock( Material.rock, "coderdojomiblock")
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

    	/** Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots */
    	Item helmet = new CoderdojomiArmorItem(armorMaterial, 0, "coderdojomi_helmet", modid + ":" + "coderdojomi_helmet", modid + ":" + "textures/model/armor/coderdojomi_layer_1.png");
    	Item plate = new CoderdojomiArmorItem(armorMaterial, 1, "coderdojomi_chestplate", modid + ":" + "coderdojomi_chestplate", modid + ":" + "textures/model/armor/coderdojomi_layer_1.png");
    	Item leggings= new CoderdojomiArmorItem(armorMaterial, 2, "coderdojomi_leggings", modid + ":" + "coderdojomi_leggings", modid + ":" + "textures/model/armor/coderdojomi_layer_2.png");
    	Item boots = new CoderdojomiArmorItem(armorMaterial, 3, "coderdojomi_boots", modid + ":" + "coderdojomi_boots", modid + ":" + "textures/model/armor/coderdojomi_layer_1.png");
        
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
		GameRegistry.registerItem(plate, plate.getUnlocalizedName());
		GameRegistry.registerItem(leggings, leggings.getUnlocalizedName());
		GameRegistry.registerItem(boots, boots.getUnlocalizedName());
    }
}
