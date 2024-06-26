package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.File

abstract class AbstractConfigurationModule<T, U> : IConfigurationModule<T, U> {
    private val base: File by inject(named("dataFolder"))
    protected val mapper: YAMLMapper by inject()
    protected open val folderName: String = ""
    protected open val fileName: String? = null

    override fun loadConfig(): T {
        val folder = File(base, folderName)
        if(!folder.exists())
            folder.mkdirs()

        val selectedFiles = if (fileName != null) {
            val file = File(folder, "$fileName.yml")
            if (file.exists())
                listOf(file)
            else
                throw IllegalStateException("Configuration file not found: ${file.path}")
        }
        else
            listAllFilesInFolder(folder).filter { it.extension == "yml" }

        val allConfigurations: List<U> = selectedFiles.map {
            processFile(it)
        }
2
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

    private fun listAllFilesInFolder(folder: File): List<File> {
        val result = mutableListOf<File>()

        folder.walk().forEach {
            if (it.isFile) result.add(it)
        }

        return result
    }
}