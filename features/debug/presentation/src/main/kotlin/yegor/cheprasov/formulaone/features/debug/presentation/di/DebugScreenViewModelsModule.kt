package yegor.cheprasov.formulaone.features.debug.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import yegor.cheprasov.formulaone.features.debug.presentation.screen.DebugViewModel

val debugScreenViewModelsModule = module {
    viewModelOf(::DebugViewModel)
}