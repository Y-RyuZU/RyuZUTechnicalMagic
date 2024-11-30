package dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler

enum class UpdatePeriod {
    TICK,
    HALF_SECOND,
    SECOND,
    TWO_SECONDS,
    FIVE_SECONDS,
    TEN_SECONDS,
    THIRTY_SECONDS,
    MINUTE;

    fun getPeriod(): Long {
        return when (this) {
            TICK -> 1
            HALF_SECOND -> 10
            SECOND -> 20
            TWO_SECONDS -> 40
            FIVE_SECONDS -> 100
            TEN_SECONDS -> 200
            THIRTY_SECONDS -> 600
            MINUTE -> 1200
        }
    }

    fun getCondition(): (Long) -> Boolean {
        return when (this) {
            TICK -> { _ -> true }
            HALF_SECOND -> { count -> count % 10 == 0L }
            SECOND -> { count -> count % 20 == 0L }
            TWO_SECONDS -> { count -> count % 40 == 0L }
            FIVE_SECONDS -> { count -> count % 100 == 0L }
            TEN_SECONDS -> { count -> count % 200 == 0L }
            THIRTY_SECONDS -> { count -> count % 600 == 0L }
            MINUTE -> { count -> count % 1200 == 0L }
        }
    }
}