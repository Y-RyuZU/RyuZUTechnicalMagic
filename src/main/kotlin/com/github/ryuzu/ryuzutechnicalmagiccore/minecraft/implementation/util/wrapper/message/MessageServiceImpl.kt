package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.message

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.AbstractMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.IMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message.MessageActionData
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toPlayer
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextReplacementConfig
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import org.koin.core.annotation.Single

@Single([IMessageService::class])
class MessageServiceImpl : AbstractMessageService() {

    override fun sendMessage(messages: List<String>, players: Set<IPlayer>) {
        val components: List<Component> = messages.map { Component.text(it) }
        sendComponentsToPlayers(components, players)
    }

    override fun sendMessage(
        messages: List<String>,
        actionPlaceholders: Map<String, MessageActionData>,
        players: Set<IPlayer>
    ) {
        val components: List<Component> = messages.map { message ->
            var component: Component = Component.text(message)

            actionPlaceholders.forEach { (message, actionData) ->
                val replacementConfig = TextReplacementConfig.builder()
                    .match(message)
                    .replacement(
                        Component.text(message).clickEvent(
                            ClickEvent.callback { actionData.action() }
                        ).hoverEvent(HoverEvent.showText(Component.text(actionData.hover.joinToString("\n"))))
                    )
                    .build()

                component = component.replaceText(replacementConfig)
            }
            component
        }

        sendComponentsToPlayers(components, players)
    }

    private fun sendComponentsToPlayers(components: List<Component>, players: Set<IPlayer>) {
        players.map { it.toPlayer() }.forEach { player ->
            components.forEach { player.sendMessage(it) }
        }
    }
}