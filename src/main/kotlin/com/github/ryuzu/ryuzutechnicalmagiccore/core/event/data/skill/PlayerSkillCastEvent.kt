package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

class PlayerSkillCastEvent(
    eventProps: IEntitySkillCastEvent,
    override var player: IPlayer,
) : IPlayerSkillCastEvent, IEntitySkillCastEvent by eventProps