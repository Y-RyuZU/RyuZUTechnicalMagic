package dev.ryuzu.ryuzutechnicalmagic.api.core.model.lang

data class LanguageKey(
    val key: String
) {
    fun get(): String = key
}