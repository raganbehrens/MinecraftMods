package unreal.mirrormod.init;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicMirror extends Item {
	public static Item magic_mirror;
	public static final String itemName = "Magic Mirror";
	
	public MagicMirror(){
		super();
		//this.setUnlocalizedName(Reference.MOD_ID + "_" + itemName);
		this.setUnlocalizedName(itemName);

		
	}
    
	/*public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
    	System.out.println("using mirror");
    	EntityPlayer user = playerIn;
    	BlockPos spawn = worldIn.getSpawnPoint();
    	System.out.println(spawn);
        (user).setPosition(spawn.getX(), spawn.getY(), spawn.getZ());
        //System.out.println("teleporting to" + spawn.getX() + spawn.getY() + spawn.getZ());
        //((EntityPlayerSP)user).posX = 0;
        //((EntityPlayerSP)user).posZ = 0;

        //playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }*/
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
    	EntityPlayer user = playerIn;
        playerIn.setActiveHand(hand);
        BlockPos spawn = worldIn.getSpawnPoint();
        (user).setPosition(spawn.getX(), spawn.getY(), spawn.getZ());
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
        
    }
}
