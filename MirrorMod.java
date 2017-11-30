package unreal.mirrormod;

import unreal.mirrormod.init.MagicMirror;
import unreal.mirrormod.init.TheSword;
import unreal.mirrormod.proxy.ClientProxy;
import unreal.mirrormod.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MirrorMod {
		public static Item magic_mirror;
		public static Item the_sword;
		
		@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
		public static CommonProxy proxy;
		
		@EventHandler
		public void preInit(FMLPreInitializationEvent event){
			magic_mirror = new MagicMirror();
			the_sword = new TheSword();
			
			GameRegistry.registerItem(magic_mirror, "magic_mirror");
			GameRegistry.registerItem(the_sword, "the_sword");
			
			proxy.preInit(event);
		}
		
		@EventHandler
		public void init(FMLInitializationEvent event){
			registerRenders();
			proxy.init(event);
		}
		
		@EventHandler
		public void postInit(FMLPostInitializationEvent event){
			proxy.postInit(event);
		}
		
		private void registerRenders(){
			if (!(proxy instanceof ClientProxy)) return;
			registerRender(magic_mirror);
			registerRender(the_sword);
		}
		
		private void registerRender(Item item){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "magic_mirror", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + "the_sword", "inventory"));

		}
}
