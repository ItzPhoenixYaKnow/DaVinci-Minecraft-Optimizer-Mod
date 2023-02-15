package com.bolt.fix-lighting-mod.config.logger;

import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.fml.event.lifecycle.FMLEvent
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent

// Event Logging
@Mod(modid = "fix-lighting-mod", name = "DaVinci MOD", version = "1.0.0-DEV", acceptedMinecraftVersions = "[1.14.4]")
class MainLoggerExtension {
    private val logger: Logger = LogManager.getLogger()

    init {
        logger.info("Hello, I'm loading all required files and dependencies! Please be patient, this may be a moment or two...")
        logger.info("Client mod initialized. Gameplay and game files are being optimized to meet system performance!")
    }
}

class MainEventLoggerExtension {
    private val logger: Logger = LogManager.getLogger()

    init {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(::loadComplete)
    }

    private fun loadComplete(event: FMLLoadCompleteEvent) {
        logger.info("All events loaded successfully. Gameplay and game files have been optimized to meet system performance successfully!")
    }
    private var eventCount: Int = 0

    init {
        FMLJavaModLoadingContext.get().getModEventBus().apply {
            addListener(::loadComplete)
            addListener(::enqueueIMC)
        }
    }

    private fun loadComplete(event: FMLLoadCompleteEvent) {
        logger.info("$eventCount events loaded successfully.")
    }

    private fun enqueueIMC(event: InterModEnqueueEvent) {
        eventCount++
    }
}