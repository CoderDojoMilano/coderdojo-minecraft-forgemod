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
	
	private String iconName;
	private String texturePath;

	/**
	 * 
	 * @param id
	 * @param armorMaterial
	 * @param armorType Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
	 * @param texturePath
	 */
	public CoderdojomiArmorItem(int id, EnumArmorMaterial armorMaterial, int armorType, String texturePath) {
		super(id, armorMaterial, 0, armorType); //0 useless...
		this.texturePath = texturePath;
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return texturePath;
	}
	
	@Override
	public Item setUnlocalizedName(String unlocalizedName) {
		iconName = CoderdojomiMod.modid + ":" + unlocalizedName;
		return super.setUnlocalizedName(unlocalizedName);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(iconName);
	}

}
