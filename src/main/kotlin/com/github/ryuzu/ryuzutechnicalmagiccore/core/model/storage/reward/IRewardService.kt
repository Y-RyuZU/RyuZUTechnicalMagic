package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.reward

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.reward.ConfiguredReward
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

interface IRewardService {
    fun giveReward(reward: ConfiguredReward, vararg players: IPlayer) = giveReward(reward, players.toSet())
    fun giveReward(reward: ConfiguredReward, players: Set<IPlayer>)
}