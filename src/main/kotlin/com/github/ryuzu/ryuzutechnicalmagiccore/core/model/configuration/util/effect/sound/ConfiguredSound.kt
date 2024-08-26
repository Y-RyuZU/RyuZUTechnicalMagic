package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.sound

import com.fasterxml.jackson.annotation.JsonCreator

data class ConfiguredSound(
    val id: String,
    val volume: Float,
    val pitch: Float,
    val delay: Long
) {
    @JsonCreator
    constructor(sound: String) :
            this(
                id = sound.split('-')[0],
                volume = sound.split('-')[1].toFloat(),
                pitch = sound.split('-')[2].toFloat(),
                delay = sound.split('-')[3].toLong()
            )
}
