package dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.service

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill.IPlayerSkillCastEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.skill.SkillTrigger

data class SkillState(
    val event: ISkillActivateEvent,
    val nextSkillIds: Map<SkillTrigger, String>,
    val relationExpirationTime: Long,
    val before: SkillState? = null,
) {
    lateinit var dataCaller: () -> dev.ryuzu.ryuzutechnicalmagic.api.core.util.TypedMap

    fun setDataCaller(dataCaller: () -> dev.ryuzu.ryuzutechnicalmagic.api.core.util.TypedMap): SkillState {
        this.dataCaller = dataCaller
        return this
    }

    fun getIndex(): Int {
        var index = 0
        var state: SkillState? = this
        while (state != null) {
            index++
            state = state.before
        }
        return index
    }

    fun getOriginalCasterPlayer(): dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer? {
        var state: SkillState = this
        while (state.before != null) {
            state = state.before!!
        }
        if(state.event is IPlayerSkillCastEvent)
            return (state.event as IPlayerSkillCastEvent).player
        return null
    }
}