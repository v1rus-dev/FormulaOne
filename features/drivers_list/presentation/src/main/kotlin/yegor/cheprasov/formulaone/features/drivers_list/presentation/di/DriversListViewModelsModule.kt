package yegor.cheprasov.formulaone.features.drivers_list.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import yegor.cheprasov.formulaone.features.drivers_list.presentation.screen.DriversListViewModel

val driversListViewModelsModule = module {
    viewModelOf(::DriversListViewModel)
}