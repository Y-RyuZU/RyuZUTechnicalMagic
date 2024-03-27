package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.skill.weapon

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillId
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.SkillState
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap


@SkillId("test_magic")
class TestMagic : ISkill {
    override fun use(
        skillParams: ConfiguredSkillParams,
        eventParams: ISkillActivateEvent,
        data: TypedMap,
        state: SkillState?
    ): () -> TypedMap {
        TODO("Not yet implemented")
    }

}