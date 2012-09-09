package net.minecraft.src;

public class ItemWeed extends ItemFood
{
    public ItemWeed(int i, int j, float f, boolean flag)
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
        setPotionEffect(Potion.digSlowdown.id, 90, 0, 1.0F);
        setPotionEffect(Potion.moveSlowdown.id, 90, 0, 1.0F);
        setPotionEffect(Potion.confusion.id, 60, 0, 1.0F);
        return new ItemStack(Item.megot);
    }
}