package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.carrytnt

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.ITeamGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer

interface ICarryTntService : ITeamGameService {
    fun tryCarryTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer)
    fun lostTNT(player: ICarryTntPlayer)
    fun placeTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer)
    fun isHoldPlayer(player: ICarryTntPlayer): Boolean
    fun isTNTPoint(location: ConfiguredIntLocation): Boolean
    fun isTNTExplodePoint(location: ConfiguredIntLocation): Boolean
    fun isTargetTNTPoint(location: ConfiguredIntLocation, player: ICarryTntPlayer): Boolean
}