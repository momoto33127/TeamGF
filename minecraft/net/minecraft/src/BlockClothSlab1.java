package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockClothSlab1 extends BlockHalfSlab
{
    public static final String name[] =
    {
        "white", "orange", "magenta", "light_blue", "yellow", "light_green",
        "pink", "gray"
    };

    public BlockClothSlab1(int id, boolean full)
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
            case 1:
                return 210;

            case 2:
                return 194;

            case 3:
                return 178;

            case 4:
                return 162;

            case 5:
                return 146;

            case 6:
                return 130;

            case 7:
                return 114;

            default:
                return 64;
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
        return Block.clothSlab1.blockID;
    }

    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 == Block.clothSlabFull1.blockID)
        {
            return;
        }

        for (int i = 0; i < 8; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    public String getFullSlabName(int i)
    {
        if (i < 0 || i > name.length - 1)
        {
            i = 0;
        }

        return super.getBlockName() + "." + name[i];
    }
}
