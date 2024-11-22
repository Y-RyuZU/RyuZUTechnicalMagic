package dev.ryuzu.ryuzutechnicalmagicapi.util.wrapper.message

data class MessageActionData(
    val action: () -> Unit,
    val hover: List<String> = emptyList(),
)