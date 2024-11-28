package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.title

interface ITitleService {
    fun sendTitle(title: String?, subtitle: String?, players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun sendTitle(messages: String?, subtitle: String?, vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = sendTitle(messages, subtitle, players.toSet())
}