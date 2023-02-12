package com.bolt.fix-lighting-mod.features.textures;

import net.minecraft.client.gui.GuiMainMenu
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.Tessellator
import net.minecraft.client.renderer.vertex.DefaultVertexFormats
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.GuiOpenEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent
import org.lwjgl.opengl.GL11

@Mod("fix-lighting-mod")
class LoadingScreenMod {
    companion object {
        private var isLoadingScreen = false
        private val BLACK = 0xFF000000.toInt()
    }

    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun onGuiOpenEvent(event: GuiOpenEvent) {
        if (event.gui is GuiMainMenu) {
            isLoadingScreen = true
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onClientTick(event: TickEvent.ClientTickEvent) {
        if (isLoadingScreen && event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().currentScreen == null) {
            isLoadingScreen = false
            // Use your own custom loading screen here
            Minecraft.getMinecraft().displayGuiScreen(CustomLoadingScreen())
        }
    }
    class CustomLoadingScreen : GuiScreen() {
        override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
            drawRect(0, 0, width, height, BLACK)
        }
    }
    class LoadingScreenMod {
        companion object {
            private var isLoadingScreen = false
            private val TEXT_COLOR = 0xFFFFFF
        }
    
        init {
            MinecraftForge.EVENT_BUS.register(this)
        }
    
        @SubscribeEvent
        fun onGuiOpenEvent(event: GuiOpenEvent) {
            if (event.gui is GuiMainMenu) {
                isLoadingScreen = true
            }
        }
    
        @SubscribeEvent(priority = EventPriority.LOWEST)
        fun onClientTick(event: TickEvent.ClientTickEvent) {
            if (isLoadingScreen && event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().currentScreen == null) {
                isLoadingScreen = false
                // Use your own custom loading screen here
                Minecraft.getMinecraft().displayGuiScreen(CustomLoadingScreen())
            }
        }
    
        class CustomLoadingScreen : GuiScreen() {
            override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
                drawDefaultBackground()
                val centerX = width / 2
                val centerY = height / 2
                val message = "DaVinci Minecraft Optimizer"
                val fontRenderer = Minecraft.getMinecraft().fontRenderer
                val messageWidth = fontRenderer.getStringWidth(message)
                val messageHeight = fontRenderer.FONT_HEIGHT
                fontRenderer.drawString(message, centerX - messageWidth / 2, centerY - messageHeight / 2, TEXT_COLOR)
            }
        }
    }
}