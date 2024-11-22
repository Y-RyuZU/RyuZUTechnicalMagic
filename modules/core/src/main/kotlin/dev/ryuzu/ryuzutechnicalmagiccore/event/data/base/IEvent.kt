package dev.ryuzu.ryuzutechnicalmagiccore.event.data.base


interface IEvent {
    var shouldNotify: Boolean
    var canChangeProperties: Boolean
}