package dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill

data class PlayerSkillCastLeftClickAirEvent(
    val eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps