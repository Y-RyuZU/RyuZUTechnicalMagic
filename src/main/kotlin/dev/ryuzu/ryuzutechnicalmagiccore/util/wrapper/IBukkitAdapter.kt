package dev.ryuzu.ryuzutechnicalmagiccore.util.wrapper

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer

interface IBukkitAdapter {
    fun getName(player: IPlayer): String
    fun isSneaking(player: IPlayer): Boolean
}