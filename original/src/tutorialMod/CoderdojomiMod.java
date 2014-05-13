package tutorialMod;

/* Basic importing */

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

    @EventHandler
    public void load(FMLInitializationEvent event)
    {

    	coderdojomiBlock = new CoderdojomiBlock(500, Material.rock).setUnlocalizedName("coderdojomiBlock");
    	
    	GameRegistry.registerBlock(coderdojomiBlock, modid + coderdojomiBlock.getUnlocalizedName().substring(5));
        
    	LanguageRegistry.addName(coderdojomiBlock, "Coderdojomi Block");
    	
    	CoderdojomiCrafting.addRecipes();
//     	
//     	GameRegistry.registerWorldGenerator(eventmanager);
//
    }  
}
