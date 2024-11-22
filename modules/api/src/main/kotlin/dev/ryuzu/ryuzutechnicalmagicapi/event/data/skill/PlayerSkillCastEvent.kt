package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill

import  dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

data class PlayerSkillCastEvent(
    val eventProps: IEntitySkillCastEvent,
    override var player: IPlayer,
) : IPlayerSkillCastEvent, IEntitySkillCastEvent by eventProps