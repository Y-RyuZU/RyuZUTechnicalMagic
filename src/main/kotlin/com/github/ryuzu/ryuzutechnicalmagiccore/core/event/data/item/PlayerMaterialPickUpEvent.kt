package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.AbstractCancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import java.util.UUID

class PlayerMaterialPickUpEvent(
    override var player: IPlayer,
    override var material: String,
    override var itemEntity: UUID,
    override var entity: UUID = player.id,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerMaterialPickUpEvent, ICancelableEvent by eventProps