package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.damage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.IPlayerDamageEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.PlayerDamageEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IDamageEventParams
import org.koin.core.component.KoinComponent
import java.util.*

interface IDamageHistoryService : KoinComponent {
    fun add(event: IPlayerDamageEvent)
    fun removeOldHistories(player: IPlayer)
    fun removeAllPlayerOldHistories()
}