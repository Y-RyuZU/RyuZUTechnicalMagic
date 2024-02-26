package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration

data class LocationFactory(val converter: LocationConverter) {
    fun create(configuredLocation: ConfiguredLocation): Any {
        return converter.convert(configuredLocation)
    }


}
