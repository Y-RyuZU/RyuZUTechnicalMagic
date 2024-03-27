package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.AbstractSkillService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.ISkillService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toIntConfigured
import org.bukkit.event.block.Action
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single
class SkillServiceImpl : AbstractSkillService(), IEventHandler {
    private val skillService: ISkillService by inject()
    private val eventListenerCollector: IEventListenerCollector by inject()

    @EventHandler
    fun onClick(event: IPlayerClickEvent) {
        val item: String = event.item ?: return
        val player = event.player
        val location = player.getDoubleLocation()
        val direction = player.getDirection()
        val skillIds = skillService.getFirstSkillIds(item, SkillTrigger.RIGHT_CLICK_AIR) ?: return

        val skillTrigger: SkillTrigger = when (event) {
            is PlayerRightClickAirEvent -> SkillTrigger.RIGHT_CLICK_AIR
            is PlayerRightClickBlockEvent -> SkillTrigger.RIGHT_CLICK_BLOCK
            is PlayerLeftClickAirEvent -> SkillTrigger.LEFT_CLICK_AIR
            is PlayerLeftClickBlockEvent -> SkillTrigger.LEFT_CLICK_BLOCK
            else -> return
        }

        skillIds.forEach {
            var skillEvent: ISkillActivateEvent = SkillActivateEvent(location, direction, item, skillTrigger, it)
            skillEvent = EntitySkillCastEvent(skillEvent, player.id)
            skillEvent = PlayerSkillCastEvent(skillEvent, player)

            skillEvent = when (event) {
                is PlayerRightClickAirEvent -> PlayerSkillCastRightClickAirEvent(skillEvent)
                is PlayerLeftClickAirEvent -> PlayerSkillCastLeftClickAirEvent(skillEvent)
                is IPlayerClickBlockEvent -> {
                    val blockLocation = event.location
                    val block = event.block
                    if (event is PlayerRightClickBlockEvent)
                        PlayerSkillCastRightClickBlockEvent(skillEvent, blockLocation, block)
                    else
                        PlayerSkillCastLeftClickBlockEvent(skillEvent, blockLocation, block)
                }
                else -> return
            }

            eventListenerCollector.publish(skillEvent)
        }
    }
}