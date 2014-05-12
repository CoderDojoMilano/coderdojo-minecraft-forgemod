package tutorialMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

 //ID della mod - nome della mod - versione della mod
@Mod(modid = CoderdojomiMod.modid, name = "Coderdojomi Mod", version = "0.5")

// solo il client deve aver installato la mod, sul server no
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class CoderdojomiMod {
	public static final String modid = "Coderdojomi_Mod";
	public static final int BLOCK_ID_CONTAINER = 500;
	public static final int BLOCK_ID_ZERO_UNO_ROCK = 501;
	public static final int BLOCK_ID_LETTER_T = 502;
	public static final int BLOCK_ID_LETTER_O = 503;
	public static final int ITEM_ID_ZERO = 5001;
	public static Item ITEM_ZERO;
	
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	ITEM_ZERO = addZeroOneItem();
     	
    	addBlockContainer();
    	Block blockT = addBlockLetter(BLOCK_ID_LETTER_T,"letter-t");
    	Block blockO = addBlockLetter(BLOCK_ID_LETTER_O,"letter-o");
    	addBlockZeroOne();
     	
     	//generazione mondo
     	GameRegistry.registerWorldGenerator(new CoderdojoWorldGenerator());

     	//crafting
     	CoderdojomiCrafting.addLetterTRecipe(blockT);
     	CoderdojomiCrafting.addLetterORecipe(blockO);
    }

	private Block addBlockLetter(int id, String texture) {
		Block blockContainer = new CoderdojomiBlock(id, Material.rock, new String[]{"white", "white", "white", texture, "white", "white"})
								.setBlockUnbreakable()
								.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(blockContainer, modid + blockContainer.blockID);
		LanguageRegistry.addName(blockContainer, "CD-" + texture);
		return blockContainer;
	}

	private void addBlockZeroOne() {
		Block blockZeroOne = new CoderdojomiBlock(BLOCK_ID_ZERO_UNO_ROCK, Material.rock, new String[]{"zero-one"}) 
								.setItemDropped(ITEM_ZERO)
								.setMaxDropped(5)
						     	.setHardness(2.0F)
						     	.setResistance(15.0F)
						     	.setStepSound(Block.soundStoneFootstep)
						     	.setCreativeTab(CreativeTabs.tabBlock);
     	
     	GameRegistry.registerBlock(blockZeroOne, modid + blockZeroOne.blockID);
     	LanguageRegistry.addName(blockZeroOne, "CD-ZeroUno");
	}

	private Block addBlockContainer() {
		//blocchi
    	//ha id 500, assomiglia all terra, ha le facce con texture custom
    	Block blockContainer = new CoderdojomiBlock(BLOCK_ID_CONTAINER, Material.ground, new String[]{"blue", "green", null, "orange", "red", "violet"}) 
    										.setHardness(1.0F)
    										.setResistance(10.0F)
    										.setStepSound(Block.soundMetalFootstep)
    										.setCreativeTab(CreativeTabs.tabBlock);
    	GameRegistry.registerBlock(blockContainer, modid + blockContainer.blockID);
     	LanguageRegistry.addName(blockContainer, "CD-Arcobaleno");
		return blockContainer;
	}

	private Item addZeroOneItem() {
		//items
     	Item itemZeroOne = new CoderdojomiItem(ITEM_ID_ZERO)
     							.setMaxStackSize(16)
     							.setCreativeTab(CreativeTabs.tabMisc)
     							.setTextureName(CoderdojomiMod.modid + ":" + "zero");
     	GameRegistry.registerItem(itemZeroOne, modid + itemZeroOne.itemID);
     	LanguageRegistry.addName(itemZeroOne, "CD-Zero");
		return itemZeroOne;
	}  
}
