package com.bolt.fix-lighting-mod.features.lighting;

import net.minecraft.util.math.BlockPos
import net.minecraft.world.LightType
import net.minecraft.world.chunk.Chunk
import net.minecraftforge.event.world.ChunkEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber

@Mod(modid = "fix-lighting-mod", name = "DaVinci MOD", version = "1.0.0-DEV", acceptedMinecraftVersions = "[1.14.4]")
class FixLightingExtension {
    @EventBusSubscriber(modid = "fix-lighting-mod", bus = EventBusSubscriber.Bus.FORGE)
    object EventHandler {
        @SubscribeEvent
        fun onChunkLoad(event: ChunkEvent.Load) {
            val chunk = event.chunk
            val world = chunk.world

            for (x in 0 until 16) {
                for (z in 0 until 16) {
                    for (y in chunk.heightMap[z shl 4 or x] + 1 downTo 0) {
                        val pos = BlockPos(x + chunk.x * 16, y, z + chunk.z * 16)
                        val state = chunk.getBlockState(pos)

                        if (!state.isAir) {
                            world.getLightFor(LightType.SKY, pos)
                            world.getLightFor(LightType.BLOCK, pos)
                            world.checkLight(pos)
                            break
                        }
                    }
                }
            }
        }
    }
}