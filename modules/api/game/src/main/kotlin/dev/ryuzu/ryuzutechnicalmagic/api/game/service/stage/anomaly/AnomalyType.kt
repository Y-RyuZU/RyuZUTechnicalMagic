package dev.ryuzu.ryuzutechnicalmagic.api.game.service.stage.anomaly

enum class AnomalyType {
    Meteor,
    Freeze,
    Thunder,
    Rain;

    companion object {
        const val CONST_METEOR = "Meteor"
        const val CONST_FREEZE = "Freeze"
    }
}