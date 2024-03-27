package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEntityEvent
import java.util.*

class EntitySkillCastEvent(
    eventProps: ISkillActivateEvent,
    override var entity: UUID,
) : IEntitySkillCastEvent, ISkillActivateEvent by eventProps