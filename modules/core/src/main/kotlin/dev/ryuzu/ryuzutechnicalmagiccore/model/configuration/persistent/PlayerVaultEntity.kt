package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent

import dev.ryuzu.ryuzutechnicalmagiccore.model.storage.Item

data class PlayerVaultEntity(
    val inventory: List<Item> = emptyList(),
    val enderChest: List<Item> = emptyList(),
    val stash: List<Item> = emptyList(),
    val releasedEnderChestPages: List<Boolean> = emptyList(),
    val balance: Long = 0
)
