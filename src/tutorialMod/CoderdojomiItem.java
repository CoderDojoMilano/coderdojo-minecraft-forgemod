package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoderdojomiItem extends Item {

    public CoderdojomiItem() {
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(CoderdojomiMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

}