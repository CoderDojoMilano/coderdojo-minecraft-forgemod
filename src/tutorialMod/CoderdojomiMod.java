package tutorialMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

 //ID della mod - nome della mod - versione della mod
@Mod(modid = CoderdojomiMod.modid, name = "Coderdojomi Mod", version = "1.0")

// solo il client deve aver installato la mod, sul server no
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class CoderdojomiMod {
	public static final String modid = "Coderdojomi_Mod";
	public static final int FIRST_BLOCK = 500;
	
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	//blocchi
    	
    	//hai id 500, assomiglia all terra, ha le facce con texture custom
    	Block coderdojomiBlock = new CoderdojomiBlock(FIRST_BLOCK, Material.ground, new String[]{"blue", "green", null, "orange", "red", "violet"}) 
    										.setHardness(1.0F)
    										.setResistance(10.0F)
    										.setStepSound(Block.soundStoneFootstep)
    										.setCreativeTab(CreativeTabs.tabBlock);
    	
    	GameRegistry.registerBlock(coderdojomiBlock, modid + coderdojomiBlock.blockID);
     	LanguageRegistry.addName(coderdojomiBlock, "CoderDojo");
     	
     	//generazione mondo
     	GameRegistry.registerWorldGenerator(new CoderdojoWorldGenerator());

     	//crafting
     	CoderdojomiCrafting.addFirstRecipes(coderdojomiBlock);
    }  
}
