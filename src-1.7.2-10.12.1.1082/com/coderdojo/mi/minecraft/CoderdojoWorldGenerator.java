package com.coderdojo.mi.minecraft;

import java.util.Random;
import java.util.logging.Logger;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;

public class CoderdojoWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		int x = chunkX * 16; 
		int z = chunkZ * 16;
		int y = 256;
		
		// La superficie solida solo al di sopra del livello del mare
		while (!world.doesBlockHaveSolidTopSurface(x, y, z) && y > 62) {
			--y;
		}
		
		//http://www.minecraftforge.net/wiki/Adding_World_Generation
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);

		//trovata coordinata y corretta ?
		if (world.doesBlockHaveSolidTopSurface(x, y, z))
		{
			world.setBlock(x, y, z, CustomMod.BLOCK_ID_CONTAINER); //punta
			world.setBlock(x, y - 4, z, CustomMod.BLOCK_ID_ZERO_UNO_ROCK); //roccia CoderDojo
			layer3x3(world, x, y - 3, z);
			layer3x3NoCenter(world, x, y - 4, z);
			layer3x3(world, x, y - 5, z);
		}

	}

	private void layer3x3(World world, int x, int y, int z) {
		layer3x3NoCenter(world, x, y, z);
		world.setBlock(x, y, z, CustomMod.BLOCK_ID_CONTAINER);
	}

	private void layer3x3NoCenter(World world, int x, int y, int z) {
		lineX(world,x, y, z - 1);
		lineX(world,x, y, z + 1);
		world.setBlock(x - 1, y, z, CustomMod.BLOCK_ID_CONTAINER); 
		world.setBlock(x + 1, y, z, CustomMod.BLOCK_ID_CONTAINER); 
	}

	private void lineX(World world, int x, int y, int z) {
		world.setBlock(x -1, y , z, CustomMod.BLOCK_ID_CONTAINER); 
		world.setBlock(x, y , z, CustomMod.BLOCK_ID_CONTAINER); 
		world.setBlock(x + 1, y , z, CustomMod.BLOCK_ID_CONTAINER);
	}

}
