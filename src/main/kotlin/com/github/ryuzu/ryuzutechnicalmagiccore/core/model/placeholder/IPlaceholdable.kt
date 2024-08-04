package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.placeholder

interface IPlaceholdable {
    fun getPlaceholder(key: String): String = getPlaceholders().get(key)?.invoke() ?: ""
    fun getPlaceholders(): Map<String, () -> String> = emptyMap()
}