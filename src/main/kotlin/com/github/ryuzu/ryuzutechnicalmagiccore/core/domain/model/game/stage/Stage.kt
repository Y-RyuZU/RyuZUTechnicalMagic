package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.stage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.team.Team
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.event.Event
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.event.IEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.generator.MapGeneratorSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.mode.IGameModeProperty

data class Stage(
    val structure: String,
    val gameMode: GameMode,
    val display: StageDisplaySet,
    val generatorSet: MapGeneratorSet,
    val teams: HashMap<String, Team>,
    val events: HashMap<Event, IEvent>,
    val parametors: IGameModeProperty
)
