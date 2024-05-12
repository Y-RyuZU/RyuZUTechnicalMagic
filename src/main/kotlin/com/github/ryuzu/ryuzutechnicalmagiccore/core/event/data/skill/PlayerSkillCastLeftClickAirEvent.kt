package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

class PlayerSkillCastLeftClickAirEvent(
    eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps