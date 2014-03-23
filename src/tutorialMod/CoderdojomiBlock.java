package tutorialMod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
	private String[] iconNames;
	private int dropId = -1;
	
	public CoderdojomiBlock(int id, Material material, String[] iconNames) {
		super(id, material);
		this.iconNames = iconNames;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		if (iconNames.length > 0 && iconNames[0] != null) {
			this.blockIcon = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + iconNames[0]);
			this.block0 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + iconNames[0]);
		}
		if (iconNames.length > 1 && iconNames[1] != null) this.block1 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + iconNames[1]);
		if (iconNames.length > 2 && iconNames[2] != null) this.block2 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + iconNames[2]);
		if (iconNames.length > 3 && iconNames[3] != null) this.block3 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + iconNames[3]);
		if (iconNames.length > 4 && iconNames[4] != null) this.block4 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + iconNames[4]);
		if (iconNames.length > 5 && iconNames[5] != null) this.block5 = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + iconNames[5]);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta){
		if (side == 0 && block0 != null) return block0;
		if (side == 1 && block1 != null) return block1;
		if (side == 2 && block2 != null) return block2;
		if (side == 3 && block3 != null) return block3;
		if (side == 4 && block4 != null) return block4;
		if (side == 5 && block5 != null) return block5;
			
		//caso base
		return this.blockIcon;
	}

	public void setItemDropped(Item item) {
		this.dropId  = item.itemID;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		if (dropId != -1) {
			return dropId;
		} else {
			return super.idDropped(par1, par2Random, par3);
		}
	}
}
