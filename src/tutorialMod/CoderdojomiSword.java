package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;

public class CoderdojomiSword extends ItemSword {

	private String iconName;

	public CoderdojomiSword(ToolMaterial toolMaterial, String name) {
		super(toolMaterial);
		setUnlocalizedName(name);
	}

	public CoderdojomiSword setIconName(String iconName) {
		this.iconName = iconName;
		return this;
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
    	this.itemIcon = iconRegister.registerIcon(this.iconName);
    }


}