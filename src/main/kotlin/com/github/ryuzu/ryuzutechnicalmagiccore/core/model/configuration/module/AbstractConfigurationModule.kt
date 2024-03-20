package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.databind.ObjectMapper
import org.koin.core.annotation.Factory
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.File

abstract class AbstractConfigurationModule<T, U>: IConfigurationModule<T, U> {
    protected val path: String by inject(named("path"))
    protected val folder: File by inject(named("folder"))
    protected val mapper: ObjectMapper by inject()

    @Factory
    override fun loadConfig(): T {
        return File(folder, path)
            .listFiles { file -> file.extension == "yml" }?.associate { file ->
                file.nameWithoutExtension to processFile(file)
            } as T? ?: hashMapOf<String, U>() as T
    }
}