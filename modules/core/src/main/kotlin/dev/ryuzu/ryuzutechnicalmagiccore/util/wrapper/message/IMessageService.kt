package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.message

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IMessageService : KoinComponent {

    fun sendMessage(messages: List<String>, players: Set<IPlayer>)
    fun sendMessage(messages: List<String>, vararg players: IPlayer) = sendMessage(messages, players.toSet())
    fun sendMessage(messages: List<String>, actionPlaceholders: Map<String, MessageActionData>, players: Set<IPlayer>)
    fun sendMessage(messages: List<String>, actionPlaceholders: Map<String, MessageActionData>, vararg players: IPlayer) = sendMessage(messages, actionPlaceholders, players.toSet())
}