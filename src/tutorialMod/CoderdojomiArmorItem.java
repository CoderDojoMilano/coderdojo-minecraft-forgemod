package tutorialMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CoderdojomiArmorItem extends ItemArmor
{

	private String layerName;

	public CoderdojomiArmorItem(ArmorMaterial material, int armorType, String name, String textureName, String layerName)
	{
	    super(material, 0, armorType);
		this.layerName = layerName;
	    setUnlocalizedName(name);
	    setTextureName(textureName);
	    setCreativeTab(CreativeTabs.tabFood);
		
	}

	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type)
	{
		return layerName;
	}

}