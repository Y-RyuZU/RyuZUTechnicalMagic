package  dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

data class EntitySkillDamageEvent(
    val eventProps: IEntityDamageEvent,
    override val skillSetId: String,
    override val skillId: String?
) : IEntitySkillDamageEvent, IEntityDamageEvent by eventProps