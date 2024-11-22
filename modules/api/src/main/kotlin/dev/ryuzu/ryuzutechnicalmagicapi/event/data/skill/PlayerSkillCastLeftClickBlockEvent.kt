package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill

import  dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation

data class PlayerSkillCastLeftClickBlockEvent(
    val eventProps: IPlayerSkillCastEvent,
    override var location: ConfiguredIntLocation,
    override var block: String,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps