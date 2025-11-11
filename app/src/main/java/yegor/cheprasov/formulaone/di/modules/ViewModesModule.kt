package yegor.cheprasov.formulaone.di.modules

import org.koin.dsl.module
import yegor.cheprasov.formulaone.features.debug.presentation.di.debugScreenViewModelsModule
import yegor.cheprasov.formulaone.features.drivers_list.presentation.di.driversListViewModelsModule
import yegor.cheprasov.formulaone.features.home.presentation.di.homeViewModelsModule
import yegor.cheprasov.formulaone.features.settings.presentation.di.settingsViewModelsModule
import yegor.cheprasov.formulaone.features.team_list.presentation.di.teamListViewModelsModule

val viewModesModule = module {
    includes(
        homeViewModelsModule,
        settingsViewModelsModule,
        driversListViewModelsModule,
        teamListViewModelsModule,
        debugScreenViewModelsModule,
    )
}