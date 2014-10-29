package tutorialMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;


public class CoderdojomiBlock extends Block {

	public CoderdojomiBlock(Material material) {

        super(material);

		this.setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(stepSound);
		
	}
	
	private IIcon sideTexture;

	@SideOnly(Side.CLIENT)
    @Override
	public IIcon getIcon(int side, int meta){
		if (side == 2 || side == 3 || side == 4 || side == 5) {
			return this.sideTexture;
		}
		return this.blockIcon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + (this.getUnlocalizedName().substring(5)));
        this.sideTexture = iconRegister.registerIcon(CoderdojomiMod.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_side");
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return CoderdojomiMod.coderdojomiItem;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
		return random.nextInt(4);
	}

}
