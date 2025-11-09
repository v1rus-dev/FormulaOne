package yegor.cheprasov.formulaone.di.modules

import org.koin.dsl.module
import yegor.cheprasov.formulaone.features.debug.presentation.di.debugScreenViewModelsModule
import yegor.cheprasov.formulaone.features.home.presentation.di.homeViewModelsModule
import yegor.cheprasov.formulaone.features.settings.presentation.di.settingsViewModelsModule

val viewModesModule = module {
    includes(
        homeViewModelsModule,
        settingsViewModelsModule,
        debugScreenViewModelsModule,
    )
}