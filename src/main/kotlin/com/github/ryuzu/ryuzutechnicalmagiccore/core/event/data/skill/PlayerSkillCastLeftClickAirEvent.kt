package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.IPlayerLeftClickEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer

class PlayerSkillCastLeftClickAirEvent(
    eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps