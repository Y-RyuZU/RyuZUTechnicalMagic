package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.databind.ObjectMapper
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.File


@Module
class LanguageModule : KoinComponent {
    protected val folder: File by inject(named("folder"))
    protected val mapper: ObjectMapper by inject()

    @Named("japanese")
    fun provideJapanese(): HashMap<String, String> {
        val languageFile =  File(folder, "ja-jp.yml")
        require(languageFile.exists()) { "Language file ja-jp.yml does not exist." }
        val languages = hashMapOf<String, String>()
        return flatten("", mapper.readValue(languageFile, Any::class.java)).toMap(languages)
    }

    fun flatten(currentPath: String, yamlData: Any?): Map<String, String> {
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