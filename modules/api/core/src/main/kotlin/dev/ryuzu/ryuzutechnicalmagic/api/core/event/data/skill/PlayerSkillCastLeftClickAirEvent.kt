package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill

data class PlayerSkillCastLeftClickAirEvent(
    val eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps