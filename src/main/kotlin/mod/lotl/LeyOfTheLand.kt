package mod.lotl

import mod.lotl.block.ModBlocks
import mod.lotl.item.ModItems
import mod.lotl.oregen.OreGeneration
import mod.lotl.oregen.ModOres
import mod.lotl.worldgen.WorldGeneration
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

/**
 * Main mod class. Should be an `object` declaration annotated with `@Mod`.
 * The modid should be declared in this object and should match the modId entry
 * in mods.toml.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
@Mod(LeyOfTheLand.ID)
object LeyOfTheLand {
    // the modid of our mod
    const val ID: String = "lotl"

    // the logger for our mod
    private val LOGGER: Logger = LogManager.getLogger()

    init {
        // Register the KDeferredRegister to the mod-specific event bus
        OreGeneration.registerOreGeneration(FORGE_BUS)
        WorldGeneration.registerWorldGeneration(FORGE_BUS)

        ModBlocks.REGISTRY.register(MOD_BUS)
        ModItems.REGISTRY.register(MOD_BUS)
        ModOres.REGISTRY.register(MOD_BUS)

        // usage of the KotlinEventBus
        MOD_BUS.addListener(::onClientSetup)
        FORGE_BUS.addListener(::onServerAboutToStart)
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerAboutToStart(event: FMLServerAboutToStartEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}
