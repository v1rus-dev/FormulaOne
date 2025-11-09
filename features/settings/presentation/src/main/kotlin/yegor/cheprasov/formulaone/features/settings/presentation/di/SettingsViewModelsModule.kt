package yegor.cheprasov.formulaone.features.settings.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import yegor.cheprasov.formulaone.features.settings.presentation.screen.SettingsViewModel

val settingsViewModelsModule = module {
    viewModelOf(::SettingsViewModel)
}