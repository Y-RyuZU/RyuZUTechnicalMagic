package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer

data class PlayerSkillCastEvent(
    val eventProps: IEntitySkillCastEvent,
    override var player: IPlayer,
) : IPlayerSkillCastEvent, IEntitySkillCastEvent by eventProps