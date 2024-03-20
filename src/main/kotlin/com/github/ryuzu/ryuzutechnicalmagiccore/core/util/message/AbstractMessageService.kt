package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.message

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import org.koin.core.component.KoinComponent
import java.util.*

abstract class AbstractMessageService : IMessageService {
    override fun sendMessage(messages: List<String>, vararg players: UUID) {
        sendMessage(messages, players.toSet())
    }
}