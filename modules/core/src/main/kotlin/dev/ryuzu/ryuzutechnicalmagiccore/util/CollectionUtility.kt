package dev.ryuzu.ryuzutechnicalmagiccore.util

class CollectionUtility {
    companion object {
        fun <K, V> Map<K, V>.getRandomKey(): K? {
            if (isEmpty()) return null
            return keys.random()
        }
    }
}