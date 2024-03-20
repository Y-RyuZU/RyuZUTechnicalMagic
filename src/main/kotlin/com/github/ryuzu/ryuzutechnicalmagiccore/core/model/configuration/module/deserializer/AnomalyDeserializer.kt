package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly.IAnomalyProperty

class AnomalyDeserializer : JsonDeserializer<IAnomalyProperty>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): IAnomalyProperty {

        TODO("Not yet implemented")
    }

}