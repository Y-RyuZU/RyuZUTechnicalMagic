package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.title

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface ITitleService {
    fun sendTitle(title: String?, subtitle: String?, players: Set<IPlayer>)
    fun sendTitle(messages: String?, subtitle: String?, vararg players: IPlayer) = sendTitle(messages, subtitle, players.toSet())
}