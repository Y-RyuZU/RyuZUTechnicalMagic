package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.service

abstract class AbstractPlayerLoginService : IPlayerLoginService {
    override fun login() {
        sendLoginMessage()
        loadEnderChest()
        loadInventory()
        loadSettings()
    }

    abstract fun sendLoginMessage()
    abstract fun loadEnderChest()
    abstract fun loadInventory()
    abstract fun loadSettings()
}