package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CoderdojomiArmorItem extends ItemArmor {
	
	private String texturePath = CoderdojomiMod.modid + ":" + "textures/model/armor/coderdojomi_layer_";

	public CoderdojomiArmorItem(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, int partNumber) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.texturePath += partNumber;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return texturePath;
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + getUnlocalizedName());
	}

}
