package yegor.cheprasov.formulaone.di.modules

import org.koin.dsl.module
import yegor.cheprasov.formulaone.core.data.di.coreDataModule
import yegor.cheprasov.formulaone.features.drivers_list.data.di.driversListDataModule

val dataModels = module {
    includes(driversListDataModule, coreDataModule)
}