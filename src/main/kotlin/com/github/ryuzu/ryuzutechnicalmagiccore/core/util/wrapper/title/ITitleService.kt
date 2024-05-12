package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.title

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface ITitleService : KoinComponent {
    fun sendTitle(title: String?, subtitle: String?, players: Set<IPlayer>)
    fun sendTitle(messages: String?, subtitle: String?, vararg players: IPlayer) = sendTitle(messages, subtitle, players.toSet())
}