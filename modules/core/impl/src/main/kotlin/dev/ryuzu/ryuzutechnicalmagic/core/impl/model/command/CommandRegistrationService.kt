package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.command

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.command.ICommandRegistrationService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.command.ICommandService
import org.koin.core.annotation.Single
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.util.ConfigurationBuilder

@Single(createdAtStart = true)
class CommandRegistrationService : ICommandRegistrationService {
    init {
        registerAll()
    }

    override fun registerAll() {
        val reflections = Reflections(
            ConfigurationBuilder()
                .forPackages("com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.command")
                .addScanners(Scanners.SubTypes)
        )

        reflections.getSubTypesOf(ICommandService::class.java).forEach {
            it.getDeclaredConstructor().newInstance().register()
        }
    }
}