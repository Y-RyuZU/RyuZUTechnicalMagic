package com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.base


interface IEvent {
    var shouldNotify: Boolean
    var canChangeProperties: Boolean
}