package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base

data class DefaultEventProperties(
    override var shouldNotify: Boolean = true,
    override var canChangeProperties: Boolean = true
) : IEvent