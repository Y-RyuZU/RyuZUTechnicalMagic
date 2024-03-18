package com.github.ryuzu.ryuzutechnicalmagiccore.core.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.display.EasingFunction
import java.util.UUID

class TypedMap(map: Map<String, Any> = hashMapOf()) : Map<String, Any> by map {
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
    fun getLocation(key: String): ConfiguredLocation {
        return ConfiguredLocation.fromString(getString(key))
    }

    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    fun getVector(key: String): ConfiguredIntVector {
        return ConfiguredIntVector.fromString(getString(key))
    }

    @Throws(IllegalArgumentException::class)
    fun getEasingFunction(key: String): EasingFunction {
        return EasingFunction.valueOf(getString(key))
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