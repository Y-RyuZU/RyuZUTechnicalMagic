package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill

class PlayerSkillCastRightClickAirEvent(
    eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps