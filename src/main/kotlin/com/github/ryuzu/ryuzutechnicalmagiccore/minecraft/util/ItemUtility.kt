package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.bukkit.Material
import org.bukkit.SoundCategory
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single
import java.util.*

@Single
class ItemUtility {
    fun createItemStack(material: Material, customModel: Int, enchantmentAura: Boolean): ItemStack {
        return ItemStack(material).apply {
            itemMeta = itemMeta.apply {
                setcustomModel(customModel)
                if (enchantmentAura)
                    addEnchant(Enchantment.DURABILITY, 1, true)
            }
        }
    }
}