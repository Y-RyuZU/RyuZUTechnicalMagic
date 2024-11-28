package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill

import  dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation

data class PlayerSkillCastRightClickBlockEvent(
    val eventProps: IPlayerSkillCastEvent,
    override var location: ConfiguredIntLocation,
    override var block: String,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps