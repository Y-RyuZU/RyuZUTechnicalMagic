package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage

interface IEntitySkillDeathEvent : IEntityDeathEvent {
    val skillSetId: String
    val skillId: String?
}