package dev.ryuzu.ryuzutechnicalmagiccore.model.storage.reward

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.reward.ConfiguredReward
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer

interface IRewardService {
    fun giveReward(reward: ConfiguredReward, vararg players: IPlayer) = giveReward(reward, players.toSet())
    fun giveReward(reward: ConfiguredReward, players: Set<IPlayer>)
}