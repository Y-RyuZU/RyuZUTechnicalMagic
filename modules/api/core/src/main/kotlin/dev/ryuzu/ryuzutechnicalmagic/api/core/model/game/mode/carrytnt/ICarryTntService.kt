package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.ITeamGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer

interface ICarryTntService : ITeamGameService {
    override fun getGamePlayer(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): ICarryTntPlayer
    fun tryCarryTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer)
    fun lostTNT(player: ICarryTntPlayer)
    fun placeTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer)
    fun isHoldPlayer(player: ICarryTntPlayer): Boolean
    fun isTargetTNTPoint(location: ConfiguredIntLocation, player: ICarryTntPlayer): Boolean
    fun isTntItemId(itemId: String): Boolean
}