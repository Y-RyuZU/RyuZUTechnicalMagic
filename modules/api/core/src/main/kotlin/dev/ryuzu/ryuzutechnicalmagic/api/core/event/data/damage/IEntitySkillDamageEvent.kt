package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

interface IEntitySkillDamageEvent : IEntityDamageEvent {
    val skillSetId: String
    val skillId: String?
}