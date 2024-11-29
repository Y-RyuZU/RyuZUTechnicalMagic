package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.storage.reward

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.reward.ConfiguredReward
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer


interface IRewardService {
    fun giveReward(reward: ConfiguredReward, vararg players: IPlayer)
}