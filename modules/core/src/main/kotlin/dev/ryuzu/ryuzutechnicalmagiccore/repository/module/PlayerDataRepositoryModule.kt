package dev.ryuzu.ryuzutechnicalmagiccore.repository.module

import dev.ryuzu.ryuzutechnicalmagiccore.repository.PlayerDataRepository
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.springframework.context.ConfigurableApplicationContext

@Module
class PlayerDataRepositoryModule : KoinComponent {
    private val context: ConfigurableApplicationContext by inject()

    @Single
    fun providePlayerDataRepository() = context.getBean(PlayerDataRepository::class.java)
}