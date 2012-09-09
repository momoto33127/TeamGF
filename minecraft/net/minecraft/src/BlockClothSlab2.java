package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockClothSlab2 extends BlockHalfSlab
{
    public static final String name[] =
    {
        "light_gray", "cyan", "purple", "blue", "brown", "green",
        "red", "black"
    };

    public BlockClothSlab2(int id, boolean full)
    {
        super(id, full, Material.cloth);

        if (!full)
        {
            this.setCreativeTab(CreativeTabs.tabBlock);
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par2 > 7)
        {
            par2 -= 8;
        }

        switch (par2)
        {
            case 0:
                return 225;

            case 1:
                return 209;

            case 2:
                return 193;

            case 3:
                return 177;

            case 4:
                return 161;

            case 5:
                return 145;

            case 6:
                return 129;

            case 7:
                return 113;

            default:
                return 225;
        }
    }

    public int getBlockTextureFromSide(int par1)
    {
        return getBlockTextureFromSideAndMetadata(par1, 0);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int damageDropped(int par1)
    {
        return par1;
    }

    /**
     * Takes a dye damage value and returns the block damage value to match
     */
    public static int getBlockFromDye(int par0)
    {
        return ~par0 & 0xf;
    }

    /**
     * Takes a block damage value and returns the dye damage value to match
     */
    public static int getDyeFromBlock(int par0)
    {
        return ~par0 & 0xf;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Block.clothSlab2.blockID;
    }

    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 == Block.clothSlabFull2.blockID)
        {
            return;
        }

        for (int i = 0; i < 8; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public String getFullSlabName(int i)
    {
        if (i < 0 || i > name.length - 1)
        {
            i = 0;
        }

        return super.getBlockName() + "." + name[i];
    }
}
