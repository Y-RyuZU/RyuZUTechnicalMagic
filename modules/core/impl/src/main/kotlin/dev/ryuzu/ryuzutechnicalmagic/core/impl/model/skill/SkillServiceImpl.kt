package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.*
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill.*
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.handler.IEventHandler
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.publisher.IEventListenerCollector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.SkillTrigger
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.service.ISkillService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item
import dev.ryuzu.ryuzutechnicalmagic.core.impl.event.handler.EventHandler
import dev.ryuzu.ryuzutechnicalmagic.core.impl.model.skill.service.AbstractSkillService
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single([ISkillService::class], true)
class SkillServiceImpl : AbstractSkillService(), IEventHandler {
    private val eventListenerCollector: IEventListenerCollector by inject()

    init {
        eventListenerCollector.registerEventListener(this)
    }

    @EventHandler
    fun onClick(event: IPlayerClickEvent) {
        println(event.item)
        println(getFirstSkillIds(event.item?.id!!,
            SkillTrigger.RIGHT_CLICK_AIR
        ))
        val item: Item = event.item ?: return
        val player = event.player
        val location = player.getEyeLocation()
        val direction = player.getEyeDirection()
        val skillIds = getFirstSkillIds(item.id,
            SkillTrigger.RIGHT_CLICK_AIR
        ) ?: return

        val skillTrigger: SkillTrigger = when (event) {
            is PlayerRightClickAirEvent -> SkillTrigger.RIGHT_CLICK_AIR
            is PlayerRightClickBlockEvent -> SkillTrigger.RIGHT_CLICK_BLOCK
            is PlayerLeftClickAirEvent -> SkillTrigger.LEFT_CLICK_AIR
            is PlayerLeftClickBlockEvent -> SkillTrigger.LEFT_CLICK_BLOCK
            else -> return
        }

        skillIds.forEach {
            var skillEvent: ISkillActivateEvent = SkillActivateEvent(location, direction, item.id, skillTrigger, it)
            skillEvent = EntitySkillCastEvent(skillEvent, player)
            skillEvent = PlayerSkillCastEvent(skillEvent, player)

            skillEvent = when (event) {
                is PlayerRightClickAirEvent -> PlayerSkillCastRightClickAirEvent(skillEvent)
                is PlayerLeftClickAirEvent -> PlayerSkillCastLeftClickAirEvent(skillEvent)
                is IPlayerClickBlockEvent -> {
                    if (event is PlayerRightClickBlockEvent)
                        PlayerSkillCastRightClickBlockEvent(skillEvent, event.location, event.block)
                    else
                        PlayerSkillCastLeftClickBlockEvent(skillEvent, event.location, event.block)
                }
                else -> return
            }

            println("onClick: ${skillEvent.skillId}")

            eventListenerCollector.publish(skillEvent)
        }
    }

    @EventHandler(priority = 200)
    fun onCast(event: ISkillActivateEvent) {
        println("onCast: ${event.skillId}")
        if(event.isCancelled) return
        use(event)
    }
}