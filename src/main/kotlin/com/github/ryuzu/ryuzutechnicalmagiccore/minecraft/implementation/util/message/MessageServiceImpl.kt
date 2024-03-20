package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.message

import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.message.AbstractMessageService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import net.kyori.adventure.text.Component
import java.util.*

class MessageServiceImpl : AbstractMessageService() {
    override fun sendMessage(messages: List<String>, players: Set<UUID>) {
        val messages: List<Component> = messages.map { Component.text(it) }
        players.map { it.toPlayer() }.forEach { player -> messages.forEach { player.sendMessage(it) } }
    }

}