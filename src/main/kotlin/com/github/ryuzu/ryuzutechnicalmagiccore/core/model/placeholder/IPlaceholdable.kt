package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.placeholder

interface IPlaceholdable {
    fun getPlaceholder(key: String): String = placeholders[key]?.invoke() ?: ""
    val placeholders: Map<String, () -> String>
}