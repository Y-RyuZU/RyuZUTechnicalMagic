package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.command

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.command.ICommandService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.ISkillService
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandPermission
import dev.jorel.commandapi.arguments.GreedyStringArgument
import dev.jorel.commandapi.arguments.MultiLiteralArgument
import dev.jorel.commandapi.arguments.StringArgument
import dev.jorel.commandapi.executors.CommandExecutor
import org.bukkit.Bukkit
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SkillCommandServiceImpl : ICommandService, KoinComponent {
    private val skillService: ISkillService by inject()

    override fun register() {
        CommandAPICommand("rtm")
            .withArguments(MultiLiteralArgument("type", "skill" , "skill-set"), MultiLiteralArgument("operation", "reload"))
            .withPermission(CommandPermission.OP)
            .executes(CommandExecutor { player, args ->
                when(args["type"]) {
                    "skill" -> {
                        when(args["operation"]) {
                            "reload" -> {
                                skillService.reloadSkill()
                                player.sendMessage("Reloaded skill")
                            }
                        }
                    }
                    "skill-set" -> {
                        when(args["operation"]) {
                            "reload" -> {
                                skillService.reloadSkillSet()
                                player.sendMessage("Reloaded skill-set")
                            }
                        }
                    }
                }
            }).register()
    }
}