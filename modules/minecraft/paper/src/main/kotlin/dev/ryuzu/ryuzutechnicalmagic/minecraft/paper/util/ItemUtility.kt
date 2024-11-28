package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single

@Single
class ItemUtility {
    fun createItemStack(material: Material, customModel: Int, enchantmentAura: Boolean): ItemStack {
        return ItemStack(material).apply {
            itemMeta = itemMeta.apply {
                setCustomModelData(customModel)
                if (enchantmentAura)
                    addEnchant(Enchantment.DURABILITY, 1, true)
            }
        }
    }
}