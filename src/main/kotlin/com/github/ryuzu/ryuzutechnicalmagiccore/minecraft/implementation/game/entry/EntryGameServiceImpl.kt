package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.AbstractEntryGameService
import org.koin.core.annotation.Factory

@Factory
class EntryGameServiceImpl: AbstractEntryGameService() {
    override fun countDownEffect(count: Long) {
        sendCountDownMessage()
        playCountDownSound()
        showCountDownVisualEffect()
    }

    private fun sendCountDownMessage() {
        TODO("Not yet implemented")
    }

    private fun playCountDownSound() {
        TODO("Not yet implemented")
    }

    private fun showCountDownVisualEffect() {
        TODO("Not yet implemented")
    }
}