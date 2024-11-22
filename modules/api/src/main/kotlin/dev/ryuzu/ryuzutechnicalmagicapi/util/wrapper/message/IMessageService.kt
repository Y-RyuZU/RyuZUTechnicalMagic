package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.message

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IMessageService {

    fun sendMessage(messages: List<String>, players: Set<IPlayer>)
    fun sendMessage(messages: List<String>, vararg players: IPlayer) = sendMessage(messages, players.toSet())
    fun sendMessage(messages: List<String>, actionPlaceholders: Map<String, MessageActionData>, players: Set<IPlayer>)
    fun sendMessage(messages: List<String>, actionPlaceholders: Map<String, MessageActionData>, vararg players: IPlayer) = sendMessage(messages, actionPlaceholders, players.toSet())
}