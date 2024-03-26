package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry.AbstractEntryGameService
import org.koin.core.annotation.Factory

@Factory
class EntryGameServiceImpl(override val location: ConfiguredIntLocation): AbstractEntryGameService(location)