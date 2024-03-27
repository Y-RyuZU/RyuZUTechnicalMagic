package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.IPlayerLeftClickEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer

class PlayerSkillCastRightClickBlockEvent(
    eventProps: IPlayerSkillCastEvent,
    override var location: ConfiguredIntLocation,
    override var block: String,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickBlockEvent, IPlayerSkillCastEvent by eventProps