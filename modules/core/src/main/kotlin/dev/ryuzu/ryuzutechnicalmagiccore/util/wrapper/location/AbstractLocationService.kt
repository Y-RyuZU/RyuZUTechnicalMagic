package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper.location

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.ILivingEntity
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntityManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class AbstractLocationService : ILocationService, KoinComponent {
    protected val entityManager: IEntityManager by inject()

    private fun isSameTeam(caster: ILivingEntity?, target: ILivingEntity, sameTeam: Boolean): Boolean {
        if(!sameTeam && caster == target) return false
        if(caster == null || caster !is IGamePlayer.GamePlayer.ITeamGamePlayer) return true
        val targetPlayer = entityManager.getPlayer(target.id)
        if(targetPlayer !is IGamePlayer.GamePlayer.ITeamGamePlayer) return true
        return (caster.team == targetPlayer.team) == sameTeam
    }

    override fun getNearbyAllyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity> =
        getNearbyLivingEntities(location, radius) { isSameTeam(caster, it, true) }

    override fun getNearbyEnemyLivingEntities(location: ConfiguredDoubleLocation, radius: Double, caster: ILivingEntity?): Set<ILivingEntity> =
        getNearbyLivingEntities(location, radius) { isSameTeam(caster, it, false) }
}