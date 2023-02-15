package com.bolt.fix-lighting-mod.features.icon;

import net.minecraft.client.Minecraft
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.common.MinecraftForge
import com.badlogic.gdx.graphics.Texture
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.GlStateManager
import net.minecraftforge.client.event.RenderLivingEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(modid = "fix-lighting-mod", name = "DaVinci MOD", version = "1.0.0-DEV", acceptedMinecraftVersions = "[1.14.4]")
class IconExtension {
    private val mc = Minecraft.getInstance()
    private val iconTexture = Texture("textures/paint.jfif")

    @SubscribeEvent
    fun onRenderLiving(event: RenderLivingEvent.Specials.Pre) {
        if (event.entity == mc.player) {
            GlStateManager.pushMatrix()
            GlStateManager.translate(event.x, event.y + event.entity.height + 0.5, event.z)
            GlStateManager.rotate(-mc.renderManager.playerViewY, 0f, 1f, 0f)
            GlStateManager.rotate(mc.renderManager.playerViewX, 1f, 0f, 0f)
            GlStateManager.scale(-0.025f, -0.025f, 0.025f)
            mc.textureManager.bindTexture(iconTexture)
            mc.ingameGui.drawTexturedModalRect(-8, -8, 0, 0, 16, 16)
            GlStateManager.popMatrix()
        }
    }
}
