package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.lang

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.lang.ILanguageService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.setting.IPlayerPersistentDataService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.lang.Language
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.lang.LanguageKey
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class LanguageService : ILanguageService, KoinComponent {
    private val playerPersistentDataService: IPlayerPersistentDataService by inject()

    private val japanese: Map<String, String> by inject(named("japanese"))
    private val english: Map<String, String> by inject(named("english"))

    override fun get(key: LanguageKey, player: IPlayer): String {
        val persistentData = playerPersistentDataService.getPersistentData(player)
        val language = persistentData.setting.language
        return when (language) {
            Language.JAPANESE -> japanese[key.key] ?: throw IllegalArgumentException("Language key('${key.key}') not found")
            Language.ENGLISH -> english[key.key] ?: throw IllegalArgumentException("Language key('${key.key}') not found")
        }
    }
}