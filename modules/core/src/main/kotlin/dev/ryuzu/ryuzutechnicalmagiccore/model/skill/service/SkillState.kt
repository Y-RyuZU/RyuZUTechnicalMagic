package dev.ryuzu.ryuzutechnicalmagiccore.model.skill.service

import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.IPlayerSkillCastEvent
import dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill.ISkillActivateEvent
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.skill.SkillTrigger
import dev.ryuzu.ryuzutechnicalmagiccore.util.TypedMap

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