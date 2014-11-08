package tutorialMod;

import java.util.Random;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;

public class CoderdojomiWorldGenerator implements IWorldGenerator {

	private Block block;

	public CoderdojomiWorldGenerator(Block coderdojomiBlock) {
		this.block = coderdojomiBlock;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		int x = chunkX * 16; 
		int z = chunkZ * 16;
		int y = 256;

		// La superficie solida solo al di sopra del livello del mare
		while (!world.doesBlockHaveSolidTopSurface(world, x, y, z) && y > 62) {
			--y;
		}
		
		//http://www.minecraftforge.net/wiki/Adding_World_Generation
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);

		//trovata coordinata y corretta ?
		if (world.doesBlockHaveSolidTopSurface(world,x, y, z))
		{
			world.setBlock(x, y, z, block); //punta
		}

	}

}