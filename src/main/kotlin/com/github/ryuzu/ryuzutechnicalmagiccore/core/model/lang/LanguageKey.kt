package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.lang

data class LanguageKey(
    val key: String
) {
    fun get(): String = key
}