package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer.GamePlayer.IActivePlayer.ActivePlayer.ITeamGamePlayer
import java.util.UUID

interface ITeamGameService : IGameService {
    fun joinTeam(player: ITeamGamePlayer)
    fun leaveTeam(player: ITeamGamePlayer)
    fun validatePlayer(player: UUID): ITeamGamePlayer
}