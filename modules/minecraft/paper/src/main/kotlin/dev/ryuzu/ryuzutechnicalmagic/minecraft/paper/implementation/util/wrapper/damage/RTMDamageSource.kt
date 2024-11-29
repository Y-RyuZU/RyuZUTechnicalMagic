package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.damage

import org.bukkit.damage.DamageSource

data class RTMDamageSource(
    val damageSource: DamageSource,
    val skillSetId: String,
    val skillId: String? = null,
) : DamageSource by damageSource