package dev.ryuzu.ryuzutechnicalmagicapi.model.lang

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface ILanguageService {
    fun get(key: LanguageKey, player: IPlayer): String
}