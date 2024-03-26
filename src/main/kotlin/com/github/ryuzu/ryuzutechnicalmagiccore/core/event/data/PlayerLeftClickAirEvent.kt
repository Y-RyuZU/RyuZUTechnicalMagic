package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data

import java.util.UUID

class PlayerLeftClickAirEvent(
    val player: UUID,
) : AbstractEvent() {
}