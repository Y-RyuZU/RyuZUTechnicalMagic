package com.github.ryuzu.ryuzutechnicalmagiccore

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module.*
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.event.BukkitEventAdapter
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.gui.GuiModule
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.ksp.generated.module
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@Module
@ComponentScan("com.github.ryuzu.ryuzutechnicalmagiccore")
@SpringBootApplication
class RyuZUTechnicalMagicCore : JavaPlugin(), KoinComponent {
    private val scoreboardLibrary: ScoreboardLibrary by inject()
    private val context: ConfigurableApplicationContext by inject()

    override fun onEnable() {
        // Plugin startup logic
        provideInstance().server.worldContainer

        val module = module {
            single { provideInstance() }
            single { provideNamespacedKey() }
            single { SpringApplication.run(RyuZUTechnicalMagicCore::class.java) }
        }

        startKoin {
            printLogger()
            modules(
                module,
                RyuZUTechnicalMagicCore().module,
                DependPluginsModule().module,
                ConfigurationModule().module,
                ConfiguredAnomalyModule().module,
                ConfiguredEntryModule().module,
                ConfiguredGameModeModule().module,
                ConfiguredGeneralParameterModule().module,
                ConfiguredGuiModule().module,
//                ConfiguredMongoConnectionInfoModule().module,
//                ConfiguredRedisConnectionInfoModule().module,
                ConfiguredRewardModule().module,
                ConfiguredSkillModule().module,
                ConfiguredSkillSetModule().module,
                ConfiguredStageModule().module,
                LanguageModule().module,
                GuiModule().module,
            )
        }

        Bukkit.getPluginManager().registerEvents(BukkitEventAdapter(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
        scoreboardLibrary.close()
        SpringApplication.exit(context)
        stopKoin()
    }

    fun provideInstance() = this

    fun provideNamespacedKey() = NamespacedKey(this, this.name)
}
