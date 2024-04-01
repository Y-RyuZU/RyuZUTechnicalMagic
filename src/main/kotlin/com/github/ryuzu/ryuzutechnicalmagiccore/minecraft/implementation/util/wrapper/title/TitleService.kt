package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.title

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.sound.ISoundService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title.ITitleService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.Title
import net.kyori.adventure.title.TitlePart
import org.koin.core.annotation.Single
import java.util.*

@Single([ITitleService::class])
class TitleService : ITitleService {

    override fun sendTitle(title: String?, subtitle: String?, players: Set<IPlayer>) {
        players.forEach { player ->
            player.toPlayer().showTitle(Title.title(Component.text(title ?: ""), Component.text(subtitle ?: "")))
        }
    }
}