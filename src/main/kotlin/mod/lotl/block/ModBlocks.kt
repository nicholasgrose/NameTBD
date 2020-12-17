package mod.lotl.block

import mod.lotl.LeyOfTheLand
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBlocks {
    // use of the new KDeferredRegister
    val REGISTRY = KDeferredRegister(ForgeRegistries.BLOCKS, LeyOfTheLand.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
    val EXAMPLE_BLOCK by REGISTRY.register("example_block") {
        Block(AbstractBlock.Properties.create(Material.BAMBOO).setLightLevel { 15 }.hardnessAndResistance(3.0f))
    }
    val ENLIGHTENED_LOG by REGISTRY.register("enlightened_log") {
        val enlightened_log = Block(AbstractBlock.Properties.create(Material.WOOD).setLightLevel { 9 }.hardnessAndResistance(2.0f))
        return@register enlightened_log
    }
}
