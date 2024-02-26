package com.github.ryuzu.ryuzutechnicalmagiccore.core.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.effect.EasingFunction

class TypedMap: HashMap<String, Any>() {
    @Throws(IllegalArgumentException::class)
    fun getString(key: String): String {
        val value = this[key]
        if(value !is String) throw IllegalArgumentException("Value for given key is not a String")

        return value
    }

    @Throws(IllegalArgumentException::class)
    fun getBoolean(key: String): Boolean {
        val value = this[key]
        if(value !is Boolean) throw IllegalArgumentException("Value for given key is not a Boolean")

        return value
    }

    @Throws(IllegalArgumentException::class)
    fun getInt(key: String): Int {
        val value = this[key]
        if(value !is Int) throw IllegalArgumentException("Value for given key is not a Int")

        return value
    }

    @Throws(IllegalArgumentException::class)
    fun getDouble(key: String): Double {
        val value = this[key]
        if(value !is Double) throw IllegalArgumentException("Value for given key is not a Double")

        return value
    }

    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    fun getLocation(key: String): ConfiguredLocation {
        val value = this[key]
        if(value !is String) throw IllegalArgumentException("Value for given key is not a String")

        return ConfiguredLocation.fromString(value)
    }

    @Throws(IllegalArgumentException::class, NumberFormatException::class)
    fun getVector(key: String): ConfiguredIntVector {
        val value = this[key]
        if(value !is String) throw IllegalArgumentException("Value for given key is not a Vector")

        return ConfiguredIntVector.fromString(value)
    }

    @Throws(IllegalArgumentException::class)
    fun getEasingFunction(key: String): EasingFunction {
        val value = this[key]
        if(value !is String) throw IllegalArgumentException("Value for given key is not a EasingFunction")

        return EasingFunction.valueOf(value)
    }
}