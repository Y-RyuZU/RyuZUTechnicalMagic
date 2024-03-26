package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap
import org.bukkit.entity.Player
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

data class SkillState(
    val nextSkillIds: Map<SkillTrigger, String>,
    val before: SkillState? = null,
) : KoinComponent {
    lateinit var dataCaller: () -> TypedMap
    lateinit var eventParams: ISkillEventPrams

    fun setDataCaller(dataCaller: () -> TypedMap): SkillState {
        this.dataCaller = dataCaller
        return this
    }

    fun setEventParams(eventParams: ISkillEventPrams): SkillState {
        this.eventParams = eventParams
        return this
    }
}