package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player

interface IItem {
    val id: String
    val amount: Int

    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "amount" to amount
        )
    }

    companion object {
        fun fromMap(map: Map<String, Any>): IItem {
            return object : IItem {
                override val id: String = map["id"] as String
                override val amount: Int = map["amount"] as Int
            }
        }
    }
}