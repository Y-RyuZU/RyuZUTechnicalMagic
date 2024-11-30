package dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.reward

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.reward.ConfiguredReward

interface IRewardService {
    fun giveReward(reward: ConfiguredReward, vararg players: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer) = giveReward(reward, players.toSet())
    fun giveReward(reward: ConfiguredReward, players: Set<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>)
}