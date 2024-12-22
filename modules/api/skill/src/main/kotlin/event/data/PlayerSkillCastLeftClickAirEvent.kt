package  event.data

data class PlayerSkillCastLeftClickAirEvent(
    val eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastLeftClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps