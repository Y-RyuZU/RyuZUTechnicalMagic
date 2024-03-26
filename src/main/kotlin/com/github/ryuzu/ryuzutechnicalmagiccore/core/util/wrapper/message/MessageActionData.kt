package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.message

data class MessageActionData(
    val action: () -> Unit,
    val hover: List<String> = emptyList(),
)
