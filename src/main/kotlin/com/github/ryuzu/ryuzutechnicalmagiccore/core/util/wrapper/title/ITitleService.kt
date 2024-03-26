package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import org.koin.core.component.KoinComponent
import java.util.*

interface ITitleService : KoinComponent {
    fun sendTitle(title: String?, subtitle: String?, players: Set<IPlayer>)
    fun sendTitle(messages: String?, subtitle: String?, vararg players: IPlayer) = sendTitle(messages, subtitle, players.toSet())
}