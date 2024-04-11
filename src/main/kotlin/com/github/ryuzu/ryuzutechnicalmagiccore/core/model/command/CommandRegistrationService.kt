package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.command

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.reflections.Reflections

@Single(createdAtStart = true)
class CommandRegistrationService : ICommandRegistrationService {
    init {
        registerAll()
    }

    override fun registerAll() {
        val reflections = Reflections("com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.command")

        reflections.getSubTypesOf(ICommandService::class.java).forEach{
            it.getDeclaredConstructor().newInstance().register()
        }
    }
}