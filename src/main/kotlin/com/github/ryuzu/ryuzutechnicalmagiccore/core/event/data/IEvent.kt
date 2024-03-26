package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data


interface IEvent {
    var shouldNotify: Boolean
    var canChangeProperties: Boolean
}