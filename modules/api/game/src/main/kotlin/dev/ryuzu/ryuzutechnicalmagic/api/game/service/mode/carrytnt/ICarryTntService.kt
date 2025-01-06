package dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.ITeamGameService
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.player.ICarryTntPlayer


interface ICarryTntService : ITeamGameService {
    override fun getGamePlayer(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): ICarryTntPlayer
    fun tryCarryTnt(location: SerIntLocation, player: ICarryTntPlayer)
    fun lostTNT(player: ICarryTntPlayer)
    fun placeTnt(location: SerIntLocation, player: ICarryTntPlayer)
    fun isHoldPlayer(player: ICarryTntPlayer): Boolean
    fun isTargetTNTPoint(location: SerIntLocation, player: ICarryTntPlayer): Boolean
    fun isTntItemId(itemId: String): Boolean
}