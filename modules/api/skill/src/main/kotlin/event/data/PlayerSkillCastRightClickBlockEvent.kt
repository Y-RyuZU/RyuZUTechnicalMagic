package  event.data

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation

data class PlayerSkillCastRightClickBlockEvent(
    val eventProps: IPlayerSkillCastEvent,
    override var location: SerIntLocation,
    override var block: String,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps