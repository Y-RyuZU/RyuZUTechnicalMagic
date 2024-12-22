package  event.data

data class PlayerSkillCastRightClickAirEvent(
    val eventProps: IPlayerSkillCastEvent,
) : IPlayerSkillCastRightClickEvent, IPlayerSkillCastClickAirEvent, IPlayerSkillCastEvent by eventProps