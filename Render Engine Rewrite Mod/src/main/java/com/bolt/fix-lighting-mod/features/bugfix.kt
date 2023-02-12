package com.bolt.fix-lighting-mod.features.bugfix;

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLConstructionEvent
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
import net.minecraftforge.fml.event.server.FMLServerStartingEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod("fix-lighting-mod")
class FeatureRemoverMod {
    private val logger: Logger = LogManager.getLogger()

    init {
        FMLJavaModLoadingContext.get().modConstructionEvent.addListener(::construct)
        FMLJavaModLoadingContext.get().getModEventBus().addListener(::loadComplete)
        MinecraftForge.EVENT_BUS.addListener(::serverStarting)
    }

    private fun construct(event: FMLConstructionEvent) {
        // Remove development or buggy features
        // ...
    }

    private fun loadComplete(event: FMLLoadCompleteEvent) {
        logger.info("All features removed.")
    }

    private fun serverStarting(event: FMLServerStartingEvent) {
        // Remove development or buggy features on the server side
        // ...
    }
}
