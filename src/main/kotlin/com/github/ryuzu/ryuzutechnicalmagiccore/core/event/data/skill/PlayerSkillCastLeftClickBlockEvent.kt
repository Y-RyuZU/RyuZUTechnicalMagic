package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation

class PlayerSkillCastLeftClickBlockEvent(
    eventProps: IPlayerSkillCastEvent,
    override var location: ConfiguredIntLocation,
    override var block: String,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps