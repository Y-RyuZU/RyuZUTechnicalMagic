package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.skill.weapon

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.IEntitySkillCastEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.skill.ISkillActivateEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.ConfiguredSkillParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.skill.param.SimpleShootParams
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.ISkill
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.SkillState
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.TypedMap
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.damage.IDamageService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.effect.IEffectService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.location.ILocationService
import org.joml.Vector3d
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class SimpleShoot : ISkill, KoinComponent {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val locationService: ILocationService by inject()
    private val effectService: IEffectService by inject()
    private val damageService: IDamageService by inject()

    override fun use(
        skillParams: ConfiguredSkillParams,
        eventParams: ISkillActivateEvent,
        data: TypedMap,
        state: SkillState?
    ): () -> TypedMap {
        val performance = skillParams.performance
        require(performance is SimpleShootParams) { "Invalid skill params" }

        val world = eventParams.skillCastLocation.world
        var projectilePoint = eventParams.skillCastLocation.vector
        val projectileVector = eventParams.direction
        fun location() = projectilePoint.toLocation(world)
        var repeatCount = 0
        val hitEntities = mutableSetOf<IEntity>()
        schedulerFactory.createParticleScheduler().apply{
            schedule(0, (performance.maxRepeat / performance.repeat) + 1L) { scheduler, count ->
            if(count == 0L) scheduler.schedule(effectService.convertTaskUnits(skillParams.effect, "ProjectileStart", location(), projectileVector, this))
            for (i in 0 until performance.repeat) {
                scheduler.schedule(effectService.convertTaskUnits(skillParams.effect, "Projectile", location(), projectileVector, this))
                val entities = locationService.getNearbyEnemyLivingEntities(
                    location(),
                    performance.hitBox,
                    (eventParams as? IEntitySkillCastEvent)?.livingEntity
                ).filter { !hitEntities.contains(it) }.toSet()
                damageService.applyDamage(eventParams, performance.damage, entities)

                projectilePoint =
                    ConfiguredDoubleVector(Vector3d(projectilePoint).add(Vector3d(projectileVector).mul(performance.speed)))

                hitEntities.addAll(entities)

                if (!performance.penetrationEntity && entities.isNotEmpty()) {
                    scheduler.abbreviate()
                    break
                }

                if (!performance.penetrationBlock && !locationService.canThrough(location(), projectileVector, performance.speed)) {
                    scheduler.abbreviate()
                    break
                }

                if (repeatCount >= performance.maxRepeat)
                    break

                repeatCount++
            }
        }
        }.promise(schedulerFactory.createParticleScheduler().apply {
                schedule { scheduler, _ ->
                scheduler.schedule(effectService.convertTaskUnits(skillParams.effect, "ProjectileEnd", location(), projectileVector, this))
                val entities = locationService.getNearbyEnemyLivingEntities(
                    location(),
                    performance.endDamageHitBox,
                    (eventParams as? IEntitySkillCastEvent)?.livingEntity
                )
                damageService.applyDamage(eventParams, performance.endDamage, entities)
            }}).runSync(true)
        return { data }
    }
}