package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.adapter

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.ILivingEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.effect.StatusEffectId
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.EntityUtility.Companion.toLivingEntity
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.koin.core.annotation.Single

@Single([IPotionEffectAdapter::class], true)
class PotionEffectAdapter : IPotionEffectAdapter {
    override fun apply(entity: ILivingEntity, statusEffectId: StatusEffectId, duration: Int, amplifier: Int) {
        entity.toLivingEntity().addPotionEffect(PotionEffect(getPotionEffectId(statusEffectId), duration, amplifier, true, false))
    }

    override fun remove(entity: ILivingEntity, statusEffectId: StatusEffectId) {
        entity.toLivingEntity().removePotionEffect(getPotionEffectId(statusEffectId))
    }

    private fun getPotionEffectId(statusEffectId: StatusEffectId): PotionEffectType = when (statusEffectId) {
        StatusEffectId.SPEED -> PotionEffectType.SPEED
        StatusEffectId.SLOW -> PotionEffectType.SLOW
        StatusEffectId.FAST_DIGGING -> PotionEffectType.FAST_DIGGING
        StatusEffectId.SLOW_DIGGING -> PotionEffectType.SLOW_DIGGING
        StatusEffectId.INCREASE_DAMAGE -> PotionEffectType.INCREASE_DAMAGE
        StatusEffectId.HEAL -> PotionEffectType.HEAL
        StatusEffectId.HARM -> PotionEffectType.HARM
        StatusEffectId.JUMP -> PotionEffectType.JUMP
        StatusEffectId.CONFUSION -> PotionEffectType.CONFUSION
        StatusEffectId.REGENERATION -> PotionEffectType.REGENERATION
        StatusEffectId.DAMAGE_RESISTANCE -> PotionEffectType.DAMAGE_RESISTANCE
        StatusEffectId.FIRE_RESISTANCE -> PotionEffectType.FIRE_RESISTANCE
        StatusEffectId.WATER_BREATHING -> PotionEffectType.WATER_BREATHING
        StatusEffectId.INVISIBILITY -> PotionEffectType.INVISIBILITY
        StatusEffectId.BLINDNESS -> PotionEffectType.BLINDNESS
        StatusEffectId.NIGHT_VISION -> PotionEffectType.NIGHT_VISION
        StatusEffectId.HUNGER -> PotionEffectType.HUNGER
        StatusEffectId.WEAKNESS -> PotionEffectType.WEAKNESS
        StatusEffectId.POISON -> PotionEffectType.POISON
        StatusEffectId.WITHER -> PotionEffectType.WITHER
        StatusEffectId.HEALTH_BOOST -> PotionEffectType.HEALTH_BOOST
        StatusEffectId.ABSORPTION -> PotionEffectType.ABSORPTION
        StatusEffectId.SATURATION -> PotionEffectType.SATURATION
        StatusEffectId.GLOWING -> PotionEffectType.GLOWING
        StatusEffectId.LEVITATION -> PotionEffectType.LEVITATION
        StatusEffectId.LUCK -> PotionEffectType.LUCK
        StatusEffectId.UNLUCK -> PotionEffectType.UNLUCK
        StatusEffectId.SLOW_FALLING -> PotionEffectType.SLOW_FALLING
        StatusEffectId.CONDUIT_POWER -> PotionEffectType.CONDUIT_POWER
        StatusEffectId.DOLPHINS_GRACE -> PotionEffectType.DOLPHINS_GRACE
        StatusEffectId.BAD_OMEN -> PotionEffectType.BAD_OMEN
        StatusEffectId.HERO_OF_THE_VILLAGE -> PotionEffectType.HERO_OF_THE_VILLAGE
        StatusEffectId.DARKNESS -> PotionEffectType.DARKNESS
        else -> throw IllegalArgumentException("Unknown effectId: $statusEffectId")
    }
}