package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import java.io.File

interface IConfigurationModule<T, U> {
    fun loadConfig(): T
    fun processFile(file: File): U
}