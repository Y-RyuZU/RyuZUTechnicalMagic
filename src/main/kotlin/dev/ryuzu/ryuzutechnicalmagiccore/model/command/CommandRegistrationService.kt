package dev.ryuzu.ryuzutechnicalmagiccore.model.command

import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.ISkill
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
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

        reflections.getSubTypesOf(dev.ryuzu.ryuzutechnicalmagiccore.model.command.ICommandService::class.java).forEach {
            it.getDeclaredConstructor().newInstance().register()
        }
    }
}