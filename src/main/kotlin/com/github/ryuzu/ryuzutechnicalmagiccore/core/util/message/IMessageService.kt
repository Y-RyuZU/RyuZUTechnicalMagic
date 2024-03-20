package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.message

import org.koin.core.component.KoinComponent
import java.util.*

interface IMessageService : KoinComponent {
    fun sendMessage(messages: List<String>, players: Set<UUID>)
    fun sendMessage(messages: List<String>, vararg players: UUID)
}