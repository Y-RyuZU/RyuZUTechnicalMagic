package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.param

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.*

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "Skill",
)
@JsonSubTypes(
    JsonSubTypes.Type(value = SimpleShootParams::class, name = "SimpleShoot"),
)
interface ISkillParams