package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoderdojomiItem extends Item {

    private String iconName;

	public CoderdojomiItem(String name) {
		setIconName(name);
        setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public CoderdojomiItem setIconName(String iconName) {
		this.iconName = iconName;
		return this;
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
    	this.itemIcon = iconRegister.registerIcon(this.iconName);
    }
    

}