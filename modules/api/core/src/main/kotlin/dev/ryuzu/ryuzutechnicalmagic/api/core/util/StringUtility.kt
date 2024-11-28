package  dev.ryuzu.ryuzutechnicalmagic.api.core.util

class StringUtility {
    companion object {
        fun Long.tickToFormattedTime(): String {
            val second = this / 20
            val minute = second / 60
            return "${String.format("%02d", minute % 60)}:${String.format("%02d", second % 60)}"
        }

        fun String.replacePlaceholders(placeholders: Map<String, String>): String =
            placeholders.entries.fold(this) { acc, (key, value) -> acc.replace(key, value) }

        fun String.replaceLambdaPlaceholders(placeholders: Map<String, () -> String>): String =
            placeholders.entries.fold(this) { acc, (key, value) -> acc.replace(key, value.invoke()) }

        fun Collection<String>.replacePlaceholders(placeholders: Map<String, String>): List<String> =
            map { it.replacePlaceholders(placeholders) }

        fun Collection<String>.replaceLambdaPlaceholders(placeholders: Map<String, () -> String>): List<String> =
            map { it.replaceLambdaPlaceholders(placeholders) }
    }
}