package  dev.ryuzu.ryuzutechnicalmagic.api.core.util

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.skill.effect.display.EasingFunction
import java.util.*

class TypedMap(map: MutableMap<String, Any> = mutableMapOf()) : MutableMap<String, Any> by map {
    @Throws(IllegalArgumentException::class)
    fun getString(key: String): String {
        val value = this[key]
        require(value is String) {"Value for given key is not a String"}

        return value
    }

    @Throws(IllegalArgumentException::class)
    fun getBoolean(key: String): Boolean {
        val value = this[key]
        require(value is Boolean) {"Value for given key is not a Boolean"}

        return value
    }

    @Throws(IllegalArgumentException::class)
    fun getInt(key: String): Int {
        val value = this[key]
        require(value is Int) {"Value for given key is not a Int"}

        return value
    }

    @Throws(IllegalArgumentException::class)
    fun getDouble(key: String): Double {
        val value = this[key]
        require(value is Double) {"Value for given key is not a Double"}

        return value
    }

    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    fun getLocation(key: String): ConfiguredIntLocation {
        return ConfiguredIntLocation(getString(key))
    }

    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    fun getVector(key: String): ConfiguredIntVector {
        return ConfiguredIntVector(getString(key))
    }

    @Throws(IllegalArgumentException::class)
    fun getEasingFunction(key: String): EasingFunction {
        return EasingFunction.valueOf(getString(key).uppercase())
    }

    @Throws(IllegalArgumentException::class)
    fun getUUID(key: String): UUID {
        return UUID.fromString(getString(key))
    }

    @Throws(IllegalArgumentException::class)
    fun getUUIDs(key: String): List<UUID> {
        val value = this[key]
        require(value is List<*>) {"Value for given key is not a List"}
        require(value.all { it is String }) {"Value for given key is not a List of String"}
        return value.map { UUID.fromString(it as String) }
    }
}