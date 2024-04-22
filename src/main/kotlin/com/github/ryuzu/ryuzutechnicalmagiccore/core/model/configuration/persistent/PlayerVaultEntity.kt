package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.persistent

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.storage.Item

data class PlayerVaultEntity(
    val inventory: List<Item> = emptyList(),
    val enderChest: List<Item> = emptyList(),
    val stash: List<Item> = emptyList(),
    val releasedEnderChestPages: List<Boolean> = emptyList(),
    val balance: Long = 0
)
