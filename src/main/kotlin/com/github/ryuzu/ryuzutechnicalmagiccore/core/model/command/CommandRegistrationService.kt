package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.command

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
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

        reflections.getSubTypesOf(ICommandService::class.java).forEach {
            it.getDeclaredConstructor().newInstance().register()
        }
    }
}