package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item

import org.bukkit.inventory.ItemStack

interface IItemProvider {
    fun getItemStack(itemId: String): ItemStack
    fun getId(itemStack: ItemStack): String?
}