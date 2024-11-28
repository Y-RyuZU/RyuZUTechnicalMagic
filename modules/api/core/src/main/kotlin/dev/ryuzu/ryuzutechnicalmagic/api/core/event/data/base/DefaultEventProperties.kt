package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base

data class DefaultEventProperties(
    override var shouldNotify: Boolean = true,
    override var canChangeProperties: Boolean = true
) : IEvent