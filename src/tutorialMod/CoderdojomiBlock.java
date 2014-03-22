package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class CoderdojomiBlock extends Block {

	@SideOnly(Side.CLIENT)
    protected Icon block0;
	@SideOnly(Side.CLIENT)
	protected Icon block1;
	@SideOnly(Side.CLIENT)
	protected Icon block2;
	@SideOnly(Side.CLIENT)
	protected Icon block3;
	@SideOnly(Side.CLIENT)
	protected Icon block4;
	@SideOnly(Side.CLIENT)
	protected Icon block5;
	
	public CoderdojomiBlock(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		this.block0 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + "green");
	    this.block1 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + "violet");
	    this.block2 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + "red");
	    this.block3 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + "orange");
	    this.block4 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + "zero-one");
	    this.block5 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + "blue");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta){
		if (side == 0) return block0;
		if (side == 1) return block1;
		if (side == 2) return block2;
		if (side == 3) return block3;
		if (side == 4) return block4;
		if (side == 5) return block5;
			
		//caso base
		return this.blockIcon;
	}

}
