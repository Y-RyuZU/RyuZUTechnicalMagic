package dev.ryuzu.ryuzutechnicalmagiccore.model.lang

data class LanguageKey(
    val key: String
) {
    fun get(): String = key
}