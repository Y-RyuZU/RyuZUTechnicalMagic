package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.skill

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntityManager
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toLocation
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Single
class SkillUtilityService : KoinComponent {
    private val entityManager: IEntityManager by inject()

    fun getNearbyPlayers(location: ConfiguredDoubleLocation, radius: Double, predicate: ((IPlayer) -> Boolean)? = null) {
        if(predicate == null) location.toLocation().getNearbyPlayers(radius)
        else location.toLocation().getNearbyPlayers(radius) { predicate(entityManager.getPlayer(it.uniqueId)) }
    }

    fun getNearbyAllyPlayers(location: ConfiguredDoubleLocation, radius: Double, caster: IPlayer) {
        getNearbyPlayers(location, radius) {
            if(caster !is ITeamGamePlayer) return@getNearbyPlayers true
            val targetPlayer = entityManager.getPlayer(it.id)
            if(targetPlayer !is ITeamGamePlayer) return@getNearbyPlayers true
            return@getNearbyPlayers (caster.team == targetPlayer.team)
        }
    }

    fun getNearEnemyPlayers(location: ConfiguredDoubleLocation, radius: Double, caster: IPlayer) {
        getNearbyPlayers(location, radius) {
            if(caster !is ITeamGamePlayer) return@getNearbyPlayers true
            val targetPlayer = entityManager.getPlayer(it.id)
            if(targetPlayer !is ITeamGamePlayer) return@getNearbyPlayers true
            return@getNearbyPlayers (caster.team != targetPlayer.team)
        }
    }
}