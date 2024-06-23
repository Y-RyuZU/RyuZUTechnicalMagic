package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import org.bukkit.damage.DamageSource

data class RTMDamageSource(
    val damageSource: DamageSource,
    val skillSetId: String,
    val skillId: String? = null,
) : DamageSource by damageSource