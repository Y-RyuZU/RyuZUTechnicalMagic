package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.title

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface ITitleService : KoinComponent {
    fun sendTitle(title: String?, subtitle: String?, players: Set<IPlayer>)
    fun sendTitle(messages: String?, subtitle: String?, vararg players: IPlayer) = sendTitle(messages, subtitle, players.toSet())
}