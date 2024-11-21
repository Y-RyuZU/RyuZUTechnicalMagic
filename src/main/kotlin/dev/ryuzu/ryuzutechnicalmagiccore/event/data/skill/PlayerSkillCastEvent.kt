package dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer

data class PlayerSkillCastEvent(
    val eventProps: IEntitySkillCastEvent,
    override var player: IPlayer,
) : IPlayerSkillCastEvent, IEntitySkillCastEvent by eventProps