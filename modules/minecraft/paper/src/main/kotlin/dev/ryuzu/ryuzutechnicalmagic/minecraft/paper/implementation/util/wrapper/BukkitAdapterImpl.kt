package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.IBukkitAdapter
import dev.ryuzu.ryuzutechnicalmagic.core.api.model.item.IItemManager
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.EntityUtility.Companion.toPlayer
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single([IBukkitAdapter::class])
class BukkitAdapterImpl : IBukkitAdapter, KoinComponent {
    private val itemManager: IItemManager by inject()

    override fun getName(player: IPlayer): String {
        return player.toPlayer().name
    }

    override fun isSneaking(player: IPlayer): Boolean {
        return player.toPlayer().isSneaking
    }
}