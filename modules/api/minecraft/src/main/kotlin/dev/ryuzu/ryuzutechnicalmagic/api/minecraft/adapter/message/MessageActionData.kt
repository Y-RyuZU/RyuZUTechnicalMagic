package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.message

data class MessageActionData(
    val action: () -> Unit,
    val hover: List<String> = emptyList(),
)
