package dev.ryuzu.ryuzutechnicalmagic.api.core.model.block

data class BlockState(
    val tags: List<BlockTag>,
    val durability: Int
)
