package net.minecraft.src;

public class ItemDrink extends ItemFood
{
    public ItemDrink(int i, int j, float f, boolean flag)
    {
        super(i, j, flag);
        maxStackSize = 1;
    }

    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.drink;
    }

    public ItemStack onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        super.onFoodEaten(itemstack, world, entityplayer);
        return new ItemStack(Item.chopeEmpty);
    }
}