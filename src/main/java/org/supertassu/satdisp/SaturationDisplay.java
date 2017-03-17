package org.supertassu.satdisp;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = SaturationDisplay.MODID, version = SaturationDisplay.VERSION)
public class SaturationDisplay
{
    public static final String MODID = "satdisp";
    public static final String VERSION = "1.0";



    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);


    }

    @SubscribeEvent
    public void onSaturationChange(RenderGameOverlayEvent event) {
        if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            String text = String.valueOf(Math.round(Minecraft.getMinecraft().thePlayer.getFoodStats().getSaturationLevel()));

            int y = ( (event.resolution.getScaledWidth() -  Minecraft.getMinecraft().fontRendererObj.getStringWidth(text)) / 2 );

            Minecraft.getMinecraft().fontRendererObj.drawString(text, y, event.resolution.getScaledHeight() - 47, 16777113);
        }
    }

}
