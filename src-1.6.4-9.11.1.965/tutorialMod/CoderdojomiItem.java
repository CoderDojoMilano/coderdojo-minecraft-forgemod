package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoderdojomiItem extends Item {

	public CoderdojomiItem(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(CoderdojomiMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}

}