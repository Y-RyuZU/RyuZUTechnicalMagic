package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.databind.ObjectMapper
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.File

abstract class AbstractConfigurationModule<T, U>: IConfigurationModule<T, U> {
    protected val folder: File by inject(named("folder"))
    protected val mapper: ObjectMapper by inject()
    protected open val fileName: String? = null

    private fun listAllFilesInFolder(folder: File): List<File> {
        val result = mutableListOf<File>()

        folder.walk().forEach {
            if (it.isFile) result.add(it)
        }

        return result
    }

    override fun loadConfig(): T {
        val selectedFiles = if (fileName != null) {
            folder.listFiles { file -> file.extension == "yml" && file.nameWithoutExtension == fileName }?.toList() ?: emptyList()
        } else {
            listAllFilesInFolder(folder).filter { it.extension == "yml" }
        }

        if (selectedFiles.isEmpty()) {
            throw IllegalStateException("No configuration files found in directory: ${folder.path}")
        }

        val allConfigurations = selectedFiles.map { file ->
            processFile(file)
        }

        return when {
            allConfigurations.all { it is Map<*, *> } -> {
                val resultMap = mutableMapOf<Any, Any>()
                allConfigurations.forEach { config ->
                    if (config is Map<*, *>)
                        resultMap.putAll(config as Map<Any, Any>)
                }
                resultMap as T
            }
            allConfigurations.all { it is Set<*> } -> {
                val resultSet = mutableSetOf<Any>()
                allConfigurations.forEach { config ->
                    if (config is Set<*>)
                        resultSet.addAll(config as Set<Any>)
                }
                resultSet as T
            }
            allConfigurations.all { it is List<*> } -> {
                val resultList = mutableListOf<Any>()
                allConfigurations.forEach { config ->
                    if (config is List<*>)
                        resultList.addAll(config as List<Any>)
                }
                resultList as T
            }
            else -> {
                allConfigurations.first() as T
            }
        }
    }

    protected abstract fun processFile(file: File): U
}