package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class CoderdojomiArmorItem extends ItemArmor {
	
	public CoderdojomiArmorItem(ArmorMaterial material, int armorType, int renderIndex, String textureName, String name) {
        super(material, armorType, renderIndex);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabCombat);
        setTextureName(textureName);
        setUnlocalizedName(name);
	}
	
}