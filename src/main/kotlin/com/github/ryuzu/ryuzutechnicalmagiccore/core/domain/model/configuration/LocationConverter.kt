package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration

interface LocationConverter {
    fun convert(location: ConfiguredLocation): Any
}