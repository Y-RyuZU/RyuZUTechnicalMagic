package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.Yaml
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.module.IConfigurationModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.File
import java.io.InputStream

abstract class AbstractConfigurationModule<ResultValue, ValuePerFile> : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.module.IConfigurationModule<ResultValue, ValuePerFile>, KoinComponent {
    private val base: File by inject(named("dataFolder"))
    protected val kaml: Yaml by inject()
    protected open val folderName: String = ""
    protected open val fileName: String? = null

    override fun loadConfig(): ResultValue {
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
            listAllFilesInFolder(folder).filter { it.extension == "yml" || it.extension == "yaml" }

        val allConfigurations: List<ValuePerFile> = selectedFiles.map {
            processStream(it.inputStream())
        }

        return when {
            allConfigurations.all { it is Map<*, *> } -> {
                val resultMap = mutableMapOf<Any, Any>()
                allConfigurations.forEach { config ->
                    if (config is Map<*, *>)
                        resultMap.putAll(config as Map<Any, Any>)
                }
                resultMap as ResultValue
            }

            allConfigurations.all { it is Set<*> } -> {
                val resultSet = mutableSetOf<Any>()
                allConfigurations.forEach { config ->
                    if (config is Set<*>)
                        resultSet.addAll(config as Set<Any>)
                }
                resultSet as ResultValue
            }

            allConfigurations.all { it is List<*> } -> {
                val resultList = mutableListOf<Any>()
                allConfigurations.forEach { config ->
                    if (config is List<*>)
                        resultList.addAll(config as List<Any>)
                }
                resultList as ResultValue
            }

            else -> {
                allConfigurations.first() as ResultValue
            }
        }
    }

    protected abstract fun processStream(stream: InputStream): ValuePerFile

    private fun listAllFilesInFolder(folder: File): List<File> {
        val result = mutableListOf<File>()

        folder.walk().forEach {
            if (it.isFile) result.add(it)
        }

        return result
    }
}