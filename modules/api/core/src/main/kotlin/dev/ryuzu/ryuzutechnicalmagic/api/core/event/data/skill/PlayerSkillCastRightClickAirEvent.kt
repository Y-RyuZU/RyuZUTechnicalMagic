package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.skill

data class PlayerSkillCastRightClickAirEvent(
    val eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps