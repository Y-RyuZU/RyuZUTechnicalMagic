package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.configuration.module

import com.charleskorn.kaml.decodeFromStream
import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.block.BlockTag
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import java.io.InputStream

@Module
class ConfiguredBlockDefaultStateModule :
    AbstractConfigurationModule<Map<String, List<BlockTag>>, Map<String, List<BlockTag>>>() {
    override val folderName: String = "block_default_state"

    @Single(createdAtStart = true)
    @Named("BlockDefaultStateConfig")
    override fun loadConfig(): Map<String, List<BlockTag>> = super.loadConfig()

    override fun processStream(stream: InputStream): Map<String, List<BlockTag>> = kaml.decodeFromStream(stream)
}