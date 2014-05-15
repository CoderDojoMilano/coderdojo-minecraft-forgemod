package com.coderdojo.mi.minecraft;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class CoderdojomiBlock extends Block {

	private String[] iconNames;
	private Icon[] icons ;
	private int dropId = -1;
	private int maxDropped = -1;
	
	public CoderdojomiBlock(int id, Material material, String[] iconNames) {
		super(id, material);
		this.iconNames = iconNames;
		icons = new Icon[6];
		setUnlocalizedName("coderDojomiBlock-" + id);  //serve altrimenti MC non riesce a gestire correttamente i nomi
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		for (int i = 0; i < iconNames.length; i++) {
			String name = iconNames[i];
			if (name != null) {
				if (i == 0) {
					this.blockIcon = iconRegister.registerIcon(CustomMod.modid + ":" + name);
				}
				icons[i] = iconRegister.registerIcon(CustomMod.modid + ":" + name);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta){
		if (icons[side] != null) {
			return icons[side];
		}
		return this.blockIcon;
	}

	public CoderdojomiBlock setItemDropped(Item item) {
		this.dropId  = item.itemID;
		return this;
	}
	
	public CoderdojomiBlock setMaxDropped(int maxDropped) {
		this.maxDropped = maxDropped;
		return this;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		if (dropId != -1) {
			return dropId;
		} else {
			return super.idDropped(par1, par2Random, par3);
		}
	}
	
	@Override
	public int quantityDropped(Random random) {
		return MathHelper.getRandomIntegerInRange(random, 1, maxDropped );
	}
}
