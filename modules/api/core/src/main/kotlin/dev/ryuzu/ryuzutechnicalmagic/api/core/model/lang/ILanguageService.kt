package dev.ryuzu.ryuzutechnicalmagic.api.core.model.lang

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

interface ILanguageService {
    fun get(key: LanguageKey, player: IPlayer): String
}