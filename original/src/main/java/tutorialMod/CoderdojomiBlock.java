package tutorialMod;

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
		
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundStoneFootstep);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
	     this.blockIcon = par1IconRegister.registerIcon(CoderdojomiMod.modid + ":" + "zero-one");
	}

}
