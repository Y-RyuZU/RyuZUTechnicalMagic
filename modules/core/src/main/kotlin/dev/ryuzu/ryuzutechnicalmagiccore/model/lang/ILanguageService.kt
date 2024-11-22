package dev.ryuzu.ryuzutechnicalmagiccore.model.lang

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer

interface ILanguageService {
    fun get(key: LanguageKey, player: IPlayer): String
}