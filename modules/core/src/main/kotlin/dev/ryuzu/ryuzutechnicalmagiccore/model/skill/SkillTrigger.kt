package dev.ryuzu.ryuzutechnicalmagiccore.model.skill

import kotlinx.serialization.SerialName

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
enum class SkillTrigger {
    @SerialName("onRightClickBlock")
    RIGHT_CLICK_BLOCK,

    @SerialName("onLeftClickBlock")
    LEFT_CLICK_BLOCK,

    @SerialName("onRightClickAir")
    RIGHT_CLICK_AIR,

    @SerialName("onLeftClickAir")
    LEFT_CLICK_AIR,

    @SerialName("onInteract")
    INTERACT,

    @SerialName("onShoot")
    SHOOT,

    @SerialName("onBlockBreak")
    BLOCK_BREAK,

    @SerialName("onConsume")
    CONSUME,

    @SerialName("onCrouch")
    CROUCH,

    @SerialName("onJump")
    JUMP,

    @SerialName("onSprint")
    SPRINT,

    @SerialName("onDrop")
    DROP,

    @SerialName("onStackDrop")
    STACK_DROP,

    @SerialName("onPickup")
    PICKUP,

    @SerialName("onHyper")
    HYPER,

    @SerialName("onAttack")
    ATTACK,

    @SerialName("onShield")
    SHIELD,

    @SerialName("onDamaged")
    DAMAGED,

    @SerialName("onDeath")
    DEATH,

    @SerialName("onSystem")
    SYSTEM,
}