package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.entity

data class MessageActionData(
    val action: () -> Unit,
    val hover: List<String> = emptyList(),
)
