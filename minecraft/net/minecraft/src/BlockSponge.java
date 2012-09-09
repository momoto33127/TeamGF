package net.minecraft.src;

public class BlockSponge extends Block
{
    protected BlockSponge(int i)
    {
        super(i, Material.sponge);
        this.blockIndexInTexture = 48;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        byte byte0 = 2;
        for (int l = par2 - byte0; l <= par2 + byte0; l++)
        {
            for (int i1 = par3 - byte0; i1 <= par3 + byte0; i1++)
            {
                for (int j1 = par4 - byte0; j1 <= par4 + byte0; j1++)
                {
                    if (par1World.getBlockMaterial(l, i1, j1) != Material.water);
                }
            }
        }
    }

    public void breakBlock(World world, int i, int j, int k)
    {
        byte byte0 = 2;
        for (int l = i - byte0; l <= i + byte0; l++)
        {
            for (int i1 = j - byte0; i1 <= j + byte0; i1++)
            {
                for (int j1 = k - byte0; j1 <= k + byte0; j1++)
                {
                    world.notifyBlocksOfNeighborChange(l, i1, j1, world.getBlockId(l, i1, j1));
                }
            }
        }
    }
}