package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.*

interface IPlayerMaterialPickUpEvent : ICancelableEvent, IPlayerEvent, IMaterialEvent {
    var itemEntity: UUID
}