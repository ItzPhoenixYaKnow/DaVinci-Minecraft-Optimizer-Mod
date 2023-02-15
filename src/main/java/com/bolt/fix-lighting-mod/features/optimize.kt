package com.bolt.fix-lighting-mod.features.optimize;

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.GameSettings
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(modid = "fix-lighting-mod", name = "DaVinci MOD", version = "1.0.0-DEV", acceptedMinecraftVersions = "[1.14.4]")
class LowEndPCSettingsExtension {
    init {
        FMLJavaModLoadingContext.get().modEventBus.addListener { event: FMLCommonSetupEvent ->
            val mc = Minecraft.getInstance()
            val gameSettings = mc.gameSettings

            gameSettings.setOptionValue(GameSettings.Options.GRAPHICS, 0)
            gameSettings.setOptionValue(GameSettings.Options.PARTICLES, 0)
            gameSettings.setOptionValue(GameSettings.Options.SMOOTH_WORLD, false)
            gameSettings.setOptionValue(GameSettings.Options.FANCY_GRASS, false)
            gameSettings.setOptionValue(GameSettings.Options.FANCY_BLOCKS, false)
            gameSettings.lockSettings()
        }
    }
}