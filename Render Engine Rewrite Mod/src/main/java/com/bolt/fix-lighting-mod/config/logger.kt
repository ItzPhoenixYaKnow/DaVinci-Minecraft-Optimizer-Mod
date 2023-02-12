package com.bolt.fix-lighting-mod.config.logger;

import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.fml.event.lifecycle.FMLEvent
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent

// Event Logging
class MainLogger {
    private val logger: Logger = LogManager.getLogger()

    init {
        logger.info("Hello, I'm loading all required files and dependencies! Please be patient, this may be a moment or two...")
        logger.info("Client mod initialized. Gameplay and game files are being optimized to meet system performance!")
    }
}

class EventLogger {
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

class FeaturesFileLoader {
    fun loadFiles(vararg filenames: String) {
        filenames.forEach { filename ->
            val file = Paths.get("features/$filename").toFile()
            val reader = FileReader(file)
            // read the contents of the file
            reader.use {
                it.readLines().forEach { line ->
                    println(line)
                }
            }
        }
    }
}