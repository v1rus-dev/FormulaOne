package yegor.cheprasov.formulaone.features.home.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import yegor.cheprasov.formulaone.features.home.presentation.screen.HomeViewModel

val homeViewModelsModule = module {
    viewModelOf(::HomeViewModel)
}