package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.service.AbstractPlayerLoginService

class PlayerLoginServiceImpl : AbstractPlayerLoginService() {
    override fun sendLoginMessage() {
        println("Welcome to the server!")
    }

    override fun loadEnderChest() {
        println("Loading ender chest...")
    }

    override fun loadInventory() {
        println("Loading inventory...")
    }

    override fun loadSettings() {
        println("Loading settings...")
    }
}