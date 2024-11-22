package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper

import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IBukkitAdapter {
    fun getName(player: IPlayer): String
    fun isSneaking(player: IPlayer): Boolean
}