package  dev.ryuzu.ryuzutechnicalmagicapi.event.data.skill

import  dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation

data class PlayerSkillCastRightClickBlockEvent(
    val eventProps: IPlayerSkillCastEvent,
    override var location: ConfiguredIntLocation,
    override var block: String,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps