package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IPlayerSkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap

data class SkillState(
    val event: ISkillActivateEvent,
    val nextSkillIds: Map<SkillTrigger, String>,
    val relationExpirationTime: Long,
    val before: SkillState? = null,
) {
    lateinit var dataCaller: () -> TypedMap

    fun setDataCaller(dataCaller: () -> TypedMap): SkillState {
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

    fun getOriginalCasterPlayer(): IPlayer? {
        var state: SkillState = this
        while (state.before != null) {
            state = state.before!!
        }
        if(state.event is IPlayerSkillCastEvent)
            return (state.event as IPlayerSkillCastEvent).player
        return null
    }
}