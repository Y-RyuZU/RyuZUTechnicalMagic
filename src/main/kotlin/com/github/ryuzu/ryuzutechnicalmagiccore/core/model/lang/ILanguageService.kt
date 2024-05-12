package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.lang

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

interface ILanguageService {
    fun get(key: LanguageKey, player: IPlayer): String
}