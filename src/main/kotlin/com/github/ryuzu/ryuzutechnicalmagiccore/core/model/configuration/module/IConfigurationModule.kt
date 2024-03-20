package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import org.koin.core.component.KoinComponent
import java.io.File

interface IConfigurationModule<T, U> : KoinComponent {
    fun loadConfig(): T
    fun processFile(file: File): U
}