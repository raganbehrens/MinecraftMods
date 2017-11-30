package unreal.mirrormod.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class TheSword extends ItemSword{
	public static Item the_sword;
	public static final String itemName = "The Sword";
	
	public TheSword(){
		super(Item.ToolMaterial.DIAMOND);
		//this.setUnlocalizedName(Reference.MOD_ID + "_" + itemName);
		this.setUnlocalizedName(itemName);

		
	}
}
