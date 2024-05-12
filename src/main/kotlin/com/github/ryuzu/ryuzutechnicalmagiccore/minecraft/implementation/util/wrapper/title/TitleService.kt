package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.title

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title.ITitleService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toPlayer
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.Title
import org.koin.core.annotation.Single

@Single([ITitleService::class])
class TitleService : ITitleService {

    override fun sendTitle(title: String?, subtitle: String?, players: Set<IPlayer>) {
        players.forEach { player ->
            player.toPlayer().showTitle(Title.title(Component.text(title ?: ""), Component.text(subtitle ?: "")))
        }
    }
}