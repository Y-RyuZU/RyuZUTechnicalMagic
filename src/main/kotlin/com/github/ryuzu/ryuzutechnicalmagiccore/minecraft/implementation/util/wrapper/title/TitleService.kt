package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.title

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title.ITitleService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.TitlePart
import org.koin.core.annotation.Single
import java.util.*

@Single
class TitleService : ITitleService {

    override fun sendTitle(title: String?, subtitle: String?, players: Set<IPlayer>) {
        title?.let { titleText ->
            val titleComponent = Component.text(titleText)
            players.forEach { player ->
                player.toPlayer().sendTitlePart(TitlePart.TITLE, titleComponent)
            }
        }
        subtitle?.let { subtitleText ->
            val subtitleComponent = Component.text(subtitleText)
            players.forEach { player ->
                player.toPlayer().sendTitlePart(TitlePart.SUBTITLE, subtitleComponent)
            }
        }
    }
}