package dev.ryuzu.ryuzutechnicalmagicapi.model.lang

data class LanguageKey(
    val key: String
) {
    fun get(): String = key
}