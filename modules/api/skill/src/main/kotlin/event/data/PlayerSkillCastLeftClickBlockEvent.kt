package  event.data

import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation

data class PlayerSkillCastLeftClickBlockEvent(
    val eventProps: IPlayerSkillCastEvent,
    override var location: ConfiguredIntLocation,
    override var block: String,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps