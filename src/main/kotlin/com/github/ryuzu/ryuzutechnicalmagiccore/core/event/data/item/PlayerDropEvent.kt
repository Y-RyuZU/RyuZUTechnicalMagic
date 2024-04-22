package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.DefaultCancelableEventProperties
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base.ICancelableEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item
import java.util.*

class PlayerDropEvent(
    override var player: IPlayer,
    override var item: Item,
    override var entity: IEntity = player,
    eventProps: ICancelableEvent = DefaultCancelableEventProperties()
) : IPlayerDropEvent, ICancelableEvent by eventProps