package  event.data

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation


data class PlayerSkillCastLeftClickBlockEvent(
    val eventProps: IPlayerSkillCastEvent,
    override var location: SerIntLocation,
    override var block: String,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps