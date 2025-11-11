package yegor.cheprasov.formulaone.features.team_list.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import yegor.cheprasov.formulaone.features.team_list.presentation.screen.TeamListViewModel

val teamListViewModelsModule = module {
    viewModelOf(::TeamListViewModel)
}