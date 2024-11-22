package dev.ryuzu.ryuzutechnicalmagicapi.model.placeholder

interface IPlaceholdable {
    fun getPlaceholder(key: String): String = placeholders[key]?.invoke() ?: ""
    val placeholders: Map<String, () -> String>
}