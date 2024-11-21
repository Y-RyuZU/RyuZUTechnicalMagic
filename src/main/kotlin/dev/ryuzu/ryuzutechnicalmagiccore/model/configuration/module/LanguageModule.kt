package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.decodeFromStream
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.File


@Module
class LanguageModule : KoinComponent {
    private val kaml: Yaml by inject()
    private val folder: File by inject(named("dataFolder"))

    @Named("japanese")
    @Single(createdAtStart = true)
    fun provideJapanese() = provideLanguage("ja_jp")

    @Named("english")
    @Single(createdAtStart = true)
    fun provideEnglish() = provideLanguage("en_us")

    private fun provideLanguage(lang: String): Map<String, String> {
        val languageFile = File(folder, "languages/${lang}.yml")
        require(languageFile.exists()) { "Language file ${lang}.yml does not exist." }

        val languages = mutableMapOf<String, String>()
        return flatten(
            "",
            kaml.decodeFromStream<Any>(languageFile.inputStream())
        ).toMap(languages)
    }

    private fun flatten(currentPath: String, yamlData: Any?): Map<String, String> {
        val flatMap = mutableMapOf<String, String>()

        if (yamlData is Map<*, *>) {
            yamlData.forEach { (key, value) ->
                val newPath = if (currentPath.isEmpty()) key.toString() else "$currentPath.$key"
                flatMap.putAll(flatten(newPath, value))
            }
        } else if (yamlData is String) {
            flatMap[currentPath] = yamlData
        }

        return flatMap
    }
}