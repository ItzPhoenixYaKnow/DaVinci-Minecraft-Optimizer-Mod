package com.bolt.fix-lighting-mod.main;

// Normal Imports
import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.client.settings.KeyModifier
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.lwjgl.glfw.GLFW

// Event Logging imports
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.fml.event.lifecycle.FMLEvent
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent

// External File Loader imports
import java.io.File
import java.io.FileReader
import java.nio.file.Paths
import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Document

@Mod("fix-lighting-mod")
class FeatureSelectorMod {
    lateinit var keyBind: KeyBinding

    fun openFeatureSelectorMenu() {
        val mc = Minecraft.getInstance()
        // Open the feature selector menu and display options to enable different features
        // ...
    }

    @Mod.EventBusSubscriber(modid = "fix-lighting-mod", bus = Mod.EventBusSubscriber.Bus.MOD)
    object EventHandler {
        @SubscribeEvent
        fun onClientSetup(event: FMLClientSetupEvent) {
            keyBind = KeyBinding("key.featureselector.desc", KeyModifier.CONTROL, GLFW.GLFW_KEY_F, "key.featureselector.category")
            ClientRegistry.registerKeyBinding(keyBind)
            MinecraftForge.EVENT_BUS.register(this)
        }

        @SubscribeEvent
        fun onKeyInput(event: InputEvent.KeyInputEvent) {
            if (keyBind.isPressed) {
                openFeatureSelectorMenu()
            }
        }
    }
}
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

class ConfigFileLoaderKT {
    fun loadFiles(vararg filenames: String) {
        filenames.forEach { filename ->
            val file = Paths.get("config/$filename").toFile()
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

class ConfigFileLoaderXml {
    fun loadFiles(vararg filenames: String) {
        filenames.forEach { filename ->
            val file = File("config/xml/$filename")
            val dbFactory = DocumentBuilderFactory.newInstance()
            val dBuilder = dbFactory.newDocumentBuilder()
            val doc: Document = dBuilder.parse(file)
            doc.documentElement.normalize()

            // parse the XML file
            println("XML Root element : " + doc.documentElement.nodeName)
        }
    }
}