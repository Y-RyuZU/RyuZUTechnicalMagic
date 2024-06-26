package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer

interface IBukkitAdapter {
    fun getName(player: IPlayer): String
    fun isSneaking(player: IPlayer): Boolean
}