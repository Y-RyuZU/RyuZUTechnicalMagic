package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.reflect.full.memberProperties

class StringSerializer<T : Any>(private val clazz: kotlin.reflect.KClass<T>) : KSerializer<T> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("CustomString", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T) {
        val properties = clazz.memberProperties.map { it.get(value).toString() }
        val serializedString = properties.joinToString(",")
        encoder.encodeString(serializedString)
    }

    override fun deserialize(decoder: Decoder): T {
        val serializedString = decoder.decodeString()
        val values = serializedString.split(",")

        val constructor = clazz.constructors.first()
        val parameters = constructor.parameters
        val args = parameters.mapIndexed { index, kParameter -> kParameter to values[index] }.toMap()
        return constructor.callBy(args)
    }
}