package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.mode.IConfiguredGameModeParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer.ActivePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTNTPlayer.CarryTNTPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredTeam
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.IConfiguredStageGameModeProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.scheduler.SimpleSchedulerFactory
import org.koin.core.component.inject
import java.util.*

abstract class AbstractCarryTNTService(
    override val world: String,
    override val stage: ConfiguredStage,
    entryPlayers: Set<UUID>,
    teamsProperties: Set<ConfiguredTeam>,
) : ICarryTNTService, AbstractTeamGameService(world, stage, entryPlayers, teamsProperties) {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val parameter: IConfiguredGameModeParameter.ConfiguredCarryTNTParameter by inject()
    private var tntLocation: ConfiguredIntVector? =
        (stage.gameProperty as IConfiguredStageGameModeProperty.ConfiguredStageCarryTNTProperty).tntSpawnPoint

    override fun carryTNT(player: CarryTNTPlayer) {
        schedulerFactory.createScheduler().schedule(period = parameter.getTNTDuration) { scheduler, _ ->
            if (!checkTntAcquisitionStatus()) scheduler.cancel()
        }.end { getTnt(player) }.runSync()
    }

    abstract override fun lostTNT(player: CarryTNTPlayer)

    abstract fun checkTntAcquisitionStatus(): Boolean

    abstract fun setTnt(location: ConfiguredIntLocation)
    abstract fun replaceTnt(location: ConfiguredIntLocation)

    protected fun getTnt(player: CarryTNTPlayer) {
        tntLocation = null
    }
}