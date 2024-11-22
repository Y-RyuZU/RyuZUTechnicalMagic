package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base

data class DefaultEventProperties(
    override var shouldNotify: Boolean = true,
    override var canChangeProperties: Boolean = true
) : IEvent