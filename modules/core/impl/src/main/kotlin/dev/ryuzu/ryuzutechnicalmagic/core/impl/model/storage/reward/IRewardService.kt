package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.storage.reward

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.reward.SerReward
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer


interface IRewardService {
    fun giveReward(reward: SerReward, vararg players: IPlayer)
}