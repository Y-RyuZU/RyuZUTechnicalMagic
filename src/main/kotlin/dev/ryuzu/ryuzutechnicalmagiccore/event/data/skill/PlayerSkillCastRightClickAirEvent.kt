package dev.ryuzu.ryuzutechnicalmagiccore.event.data.skill

data class PlayerSkillCastRightClickAirEvent(
    val eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps