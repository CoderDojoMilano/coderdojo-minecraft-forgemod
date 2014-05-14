package tutorialMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EventManger implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch (world.provider.dimensionId){
		
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
	}
		
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
	}

	private void generateSurface(World world, Random random, int x, int z) {
		
		this.addOreSpawn(CoderdojomiMod.coderdojomiBlock, world, random, x, z, 16, 16, 4 + random.nextInt(3), 20, 15, 70);
	}

	private void generateNether(World world, Random random, int x, int z) {
	}
	
	/**
	 * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
	 * 
	 * @param Il Blocco da generare
	 * @param Il mondo nel quale il blocco sarà generato
	 * @param Un oggetto Random per indicare posizioni a caso in cui generare il blocco
	 * @param Un intero per passare la coordinata X al metodo di generazione del blocco
	 * @param Un intero per passare la coordinata Z al metodo di generazione del blocco
	 * @param Un intero per impostare la massima coordinata X ammessa per la generazione, rispetto all'asse X per ogni Chunk
	 * @param Un intero per impostare la massima coordinata Z ammessa per la generazione, rispetto all'asse Z per ogni Chunk
	 * @param Un intero per impostare la dimensione massima di una vena di blocchi generata
	 * @param Un intero che indica la probabilità che il blocco venga generato in un Chunk
	 * @param Un intero per assegnare il valore minimo della coordinata Y alla quale il blocco può essere generato
	 * @param Un intero per assegnare il valore massimo della coordinata Y alla quale il blocco può essere generato
	 **/
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block.blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}

}
