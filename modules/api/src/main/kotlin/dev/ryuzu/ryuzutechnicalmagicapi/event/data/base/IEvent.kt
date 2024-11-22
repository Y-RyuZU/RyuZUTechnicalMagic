package dev.ryuzu.ryuzutechnicalmagicapi.event.data.base


interface IEvent {
    var shouldNotify: Boolean
    var canChangeProperties: Boolean
}