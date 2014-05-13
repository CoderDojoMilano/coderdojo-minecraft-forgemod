package tutorialMod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class CoderdojomiBlock extends Block {

	public CoderdojomiBlock(int id, Material material) {
		
		super(id, material);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundStoneFootstep);
		
	}
	
	@SideOnly(Side.CLIENT)
	private Icon sideTexture;
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta){
		if (side == 2 || side == 3 || side == 4 || side == 5) {
			return this.sideTexture;
		}
		return this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
	     this.blockIcon = par1IconRegister.registerIcon(CoderdojomiMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	     this.sideTexture = par1IconRegister.registerIcon(CoderdojomiMod.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_side");

	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return CoderdojomiMod.coderdojomiItem.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return par1Random.nextInt(4);
	}

}
