package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

data class EntitySkillDamageByEntityEvent(
    val eventProps: IEntityDamageByEntityEvent,
    override val skillSetId: String,
    override val skillId: String?,
) : IEntitySkillDamageByEntityEvent, IEntityDamageByEntityEvent by eventProps