package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.display

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display.IConfiguredDisplay
import org.koin.core.component.KoinComponent

interface ITextDisplayService : KoinComponent {
    fun displayText(texts: IConfiguredDisplay.ConfiguredTextDisplay, location: ConfiguredIntLocation)
}