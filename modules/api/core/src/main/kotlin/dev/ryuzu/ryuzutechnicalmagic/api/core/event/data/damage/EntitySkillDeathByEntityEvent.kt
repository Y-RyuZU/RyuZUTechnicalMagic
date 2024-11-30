package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

data class EntitySkillDeathByEntityEvent(
    val eventProps: IEntityDeathByEntityEvent,
    override val skillSetId: String,
    override val skillId: String?,
) : IEntitySkillDeathByEntityEvent, IEntityDeathByEntityEvent by eventProps