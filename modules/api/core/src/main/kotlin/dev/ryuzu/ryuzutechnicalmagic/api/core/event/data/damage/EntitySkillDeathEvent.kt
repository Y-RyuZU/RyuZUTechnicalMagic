package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

data class EntitySkillDeathEvent(
    val eventProps: IEntityDeathEvent,
    override val skillSetId: String,
    override val skillId: String?
) : IEntitySkillDeathEvent, IEntityDeathEvent by eventProps