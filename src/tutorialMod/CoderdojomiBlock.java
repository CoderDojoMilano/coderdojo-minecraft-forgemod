package tutorialMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class CoderdojomiBlock extends Block {

	private String topBlockTextureName;
	private String bottomBlockTextureName;
	private String northBlockTextureName;
	private String southBlockTextureName;
	private String westBlockTextureName;
	private String eastBlockTextureName;
	private IIcon topIcon;
	private IIcon bottomIcon;
	private IIcon northIcon;
	private IIcon southIcon;
	private IIcon westIcon;
	private IIcon eastIcon;
	private String name;
	private int quantityDropped = 1;
	private Item itemDropped;

	public CoderdojomiBlock(Material material, String name) {
        super(material);

        this.name = name;
		this.setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(stepSound);
		
	}
	
	public CoderdojomiBlock setItemDropped(Item itemDropped) {
		this.itemDropped = itemDropped;
		return this;
	}
	
	public CoderdojomiBlock setQuantityDropped(int quantityDropped) {
		this.quantityDropped = quantityDropped;
		return this;
	}
	
	public CoderdojomiBlock setTopBlockTextureName(String name) {
		this.topBlockTextureName = name;
		return this;
	}
	
	public CoderdojomiBlock setBottomBlockTextureName(String name) {
		this.bottomBlockTextureName = name;
		return this;
	}
	
	public CoderdojomiBlock setNorthBlockTextureName(String name) {
		this.northBlockTextureName = name;
		return this;
	}
	
	public CoderdojomiBlock setSouthBlockTextureName(String name) {
		this.southBlockTextureName = name;
		return this;
	}
	
	public CoderdojomiBlock setWestBlockTextureName(String name) {
		this.westBlockTextureName = name;
		return this;
	}
	
	public CoderdojomiBlock setEastBlockTextureName(String name) {
		this.eastBlockTextureName = name;
		return this;
	}
	
	@Override
	public String getUnlocalizedName() {
		return this.name;
	}
	
	@Override
	public String getLocalizedName() {
		return this.name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.topIcon = iconRegister.registerIcon(this.topBlockTextureName);
		this.bottomIcon = iconRegister.registerIcon(this.bottomBlockTextureName);
		this.northIcon = iconRegister.registerIcon(this.northBlockTextureName);
		this.southIcon = iconRegister.registerIcon(this.southBlockTextureName);
		this.westIcon = iconRegister.registerIcon(this.westBlockTextureName);
		this.eastIcon = iconRegister.registerIcon(this.eastBlockTextureName);
	}
	
	

	@SideOnly(Side.CLIENT)
    @Override
	public IIcon getIcon(int side, int meta){
		switch (side) {
		case 0: return this.bottomIcon;
		case 1: return this.topIcon; 
		case 2: return this.westIcon; 
		case 3: return this.eastIcon; 
		case 4: return this.southIcon; 
		case 5: return this.northIcon; 
		default: return null; 
		}
	}
	
	public int quantityDropped(Random random)
    {
        return this.itemDropped == null ? 0 : this.quantityDropped ;
    }

    public Item getItemDropped(int x, Random random, int y)
    {
        return this.itemDropped;
    }

}
