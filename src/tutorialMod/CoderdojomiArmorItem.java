package tutorialMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

/**
 * itemRegistry.addObject(298, "leather_helmet", (new ItemArmor(ItemArmor.ArmorMaterial.CLOTH, 0, 0)).setUnlocalizedName("helmetCloth").setTextureName("leather_helmet"));
 */
public class CoderdojomiArmorItem extends ItemArmor {
	
	private String iconName;

	public CoderdojomiArmorItem(ArmorMaterial material, int armorType, int renderIndex, String textureName) {
        super(material, armorType, renderIndex);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabCombat);
        setTextureName(textureName);
	}

    /*
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
	*/

}