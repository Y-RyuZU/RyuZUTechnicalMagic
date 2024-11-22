package dev.ryuzu.ryuzutechnicalmagicapi.model.storage.reward

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.reward.ConfiguredReward
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IRewardService {
    fun giveReward(reward: ConfiguredReward, vararg players: IPlayer) = giveReward(reward, players.toSet())
    fun giveReward(reward: ConfiguredReward, players: Set<IPlayer>)
}