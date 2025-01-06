package service

import data.skill.SkillTrigger
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.core.util.TypedMap
import event.data.IPlayerSkillCastEvent
import event.data.ISkillActivateEvent

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