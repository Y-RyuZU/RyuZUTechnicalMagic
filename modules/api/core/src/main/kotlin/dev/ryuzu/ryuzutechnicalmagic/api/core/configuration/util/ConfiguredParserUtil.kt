package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util

object ConfiguredParserUtil {
    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    inline fun <reified T> fromStringPart(string: String, index: Int, expectedSize: Int): T {
        val split = string.split(",")

        if (split.size != expectedSize) {
            throw IllegalArgumentException("Invalid vector format, expected $expectedSize parts but got ${split.size}")
        }

        val part = split[index]

        return when (T::class) {
            String::class -> part as T
            Float::class -> part.toFloatOrNull() as T? ?: throw NumberFormatException("Invalid vector format, expected float values")
            Double::class -> part.toDoubleOrNull() as T? ?: throw NumberFormatException("Invalid vector format, expected double values")
            Int::class -> part.toIntOrNull() as T? ?: throw NumberFormatException("Invalid vector format, expected integer values")
            Long::class -> part.toLongOrNull() as T? ?: throw NumberFormatException("Invalid vector format, expected long values")
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }
}