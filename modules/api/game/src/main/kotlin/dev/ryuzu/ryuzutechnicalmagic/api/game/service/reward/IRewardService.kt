package dev.ryuzu.ryuzutechnicalmagic.api.game.service.reward

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.game.data.reward.SerReward


interface IRewardService {
    fun giveReward(reward: SerReward, vararg players: IPlayer) = giveReward(reward, players.toSet())
    fun giveReward(reward: SerReward, players: Set<IPlayer>)
}