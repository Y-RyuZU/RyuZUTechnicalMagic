package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter

interface IBukkitAdapter {
    fun getName(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): String
    fun isSneaking(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
}