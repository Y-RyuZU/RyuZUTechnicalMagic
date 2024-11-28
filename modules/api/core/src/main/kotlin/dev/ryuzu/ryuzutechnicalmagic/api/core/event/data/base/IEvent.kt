package dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.base


interface IEvent {
    var shouldNotify: Boolean
    var canChangeProperties: Boolean
}