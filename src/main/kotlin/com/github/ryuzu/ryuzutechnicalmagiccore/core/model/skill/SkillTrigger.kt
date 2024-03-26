package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill


import com.fasterxml.jackson.annotation.JsonValue

enum class SkillTrigger(@JsonValue val trigger: String) {
    RIGHT_CLICK_BLOCK("onRightClickBlock"),
    LEFT_CLICK_BLOCK("onLeftClickBlock"),
    RIGHT_CLICK_AIR("onRightClickAir"),
    LEFT_CLICK_AIR("onLeftClickAir"),
    INTERACT("onInteract"),
    SHOOT("onShoot"),
    BLOCK_BREAK("onBlockBreak"),
    CONSUME("onConsume"),
    CROUCH("onCrouch"),
    JUMP("onJump"),
    SPRINT("onSprint"),
    DROP("onDrop"),
    STACK_DROP("onStackDrop"),
    PICKUP("onPickup"),
    HYPER("onHyper"),
    ATTACK("onAttack"),
    SHIELD("onShield"),
    DAMAGED("onDamaged"),
    DEATH("onDeath"),
    SYSTEM("onSystem"),
}