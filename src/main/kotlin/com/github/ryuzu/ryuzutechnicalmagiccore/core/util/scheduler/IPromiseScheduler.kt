package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler

interface IPromiseScheduler<T> : ISimpleScheduler {
    fun <R> then(task: (T) -> R): IPromiseScheduler<R>
    fun <R> thenAsync(task: (T) -> R): IPromiseScheduler<R>
    fun <R> thenUnit(task: (T) -> Unit): IPromiseScheduler<R>
    fun <R> thenUnitAsync(task: (T) -> Unit): IPromiseScheduler<R>
}