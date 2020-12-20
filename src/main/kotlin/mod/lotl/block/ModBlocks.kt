package mod.lotl.block

import mod.lotl.LeyOfTheLand
import net.minecraft.block.*
import net.minecraft.block.material.Material
import net.minecraft.block.material.MaterialColor
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockReader
import net.minecraftforge.common.ToolType
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBlocks {
    // use of the new KDeferredRegister
    val REGISTRY = KDeferredRegister(ForgeRegistries.BLOCKS, LeyOfTheLand.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
    val ENLIGHTENED_LOG by REGISTRY.register("enlightened_log") {
        val magic = Material.Builder(MaterialColor.WOOD).build()
        ColumnBlock(
            AbstractBlock.Properties.create(magic).setLightLevel { 9 }.hardnessAndResistance(2.0f).sound(SoundType.WOOD)
        )
    }

    val CRYSTALLIZED_LEY_ORE by REGISTRY.register("crystallized_ley_ore") {
        Block(
            AbstractBlock.Properties.create(Material.ROCK).setLightLevel { 7 }.hardnessAndResistance(3.0f)
                .setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2)
        )
    }

    val ENLIGHTENED_LEAVES by REGISTRY.register("enlightened_leaves") {
        LeavesBlock(
            AbstractBlock.Properties.create(Material.LEAVES).setLightLevel { 9 }.sound(SoundType.PLANT)
                .hardnessAndResistance((.2f)).notSolid().setSuffocates { _: BlockState, _: IBlockReader, _: BlockPos -> false }
                .setBlocksVision { _: BlockState, _: IBlockReader, _: BlockPos -> false }
        )
    }
}
