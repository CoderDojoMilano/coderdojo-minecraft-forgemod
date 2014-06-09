package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class CoderdojomiSword extends ItemSword {

	public CoderdojomiSword(int id, EnumToolMaterial toolMaterial) {
		super(id, toolMaterial);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
