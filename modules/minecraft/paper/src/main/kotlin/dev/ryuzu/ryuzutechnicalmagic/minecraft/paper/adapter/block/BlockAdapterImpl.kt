package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.block

import com.github.retrooper.packetevents.PacketEvents
import com.github.retrooper.packetevents.util.Vector3i
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerBlockBreakAnimation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.block.IBlockAdapter
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.location.ILocationAdapter
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.random.Random

@Single([IBlockAdapter::class])
class BlockAdapterImpl : IBlockAdapter, KoinComponent {
    private val blockProviders: List<IBlockProvider> = getKoin().getAll<IBlockProvider>().sortedBy { it.priority }
    private val locationAdapter: ILocationAdapter by inject()


    override fun setBlock(location: ConfiguredIntLocation, id: String) =
        blockProviders.firstOrNull { it.existsId(id) }?.setBlock(location, id) ?: throw IllegalArgumentException("Block not found with id $id")

    override fun getBlockId(location: ConfiguredIntLocation): String =
        blockProviders.firstNotNullOfOrNull { it.getBlockId(location) } ?: throw IllegalArgumentException("Block not found at $location")

    override fun getHardness(id: String): Int =
        blockProviders.firstOrNull { it.existsId(id) }?.getHardness(id) ?: throw IllegalArgumentException("Block not found with id $id")

    override fun setBlockDestroyState(location: ConfiguredIntLocation, destroyState: Byte) {
        val animationId = Random.nextInt() // ナゾのID
        val vector = Vector3i(location.vector.x, location.vector.y, location.vector.z)
        val packet = WrapperPlayServerBlockBreakAnimation(animationId, vector, destroyState)

        val playerRange = 64.0

        locationAdapter.getNearbyPlayers(location.toDoubleLocation(), playerRange).forEach { player ->
            PacketEvents.getAPI().playerManager.sendPacket(player.toPlayer(), packet)
        }
    }
}