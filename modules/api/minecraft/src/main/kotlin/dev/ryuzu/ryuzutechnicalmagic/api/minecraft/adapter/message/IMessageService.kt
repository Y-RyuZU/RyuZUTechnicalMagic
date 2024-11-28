package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.message

interface IMessageService {

    fun sendMessage(messages: List<String>, players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun sendMessage(messages: List<String>, vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = sendMessage(messages, players.toSet())
    fun sendMessage(messages: List<String>, actionPlaceholders: Map<String, MessageActionData>, players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
    fun sendMessage(messages: List<String>, actionPlaceholders: Map<String, MessageActionData>, vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = sendMessage(messages, actionPlaceholders, players.toSet())
}