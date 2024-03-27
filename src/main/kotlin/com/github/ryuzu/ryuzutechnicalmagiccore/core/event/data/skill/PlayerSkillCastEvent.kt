package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.IEntityEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

class PlayerSkillCastEvent(
    eventProps: IEntitySkillCastEvent,
    override var player: IPlayer,
) : IPlayerSkillCastEvent, IEntitySkillCastEvent by eventProps