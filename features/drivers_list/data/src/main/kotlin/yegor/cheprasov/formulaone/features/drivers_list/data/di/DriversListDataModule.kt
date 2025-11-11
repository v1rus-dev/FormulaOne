package yegor.cheprasov.formulaone.features.drivers_list.data.di

import org.koin.dsl.module
import yegor.cheprasov.formulaone.core.data.repositories.DriversRepository
import yegor.cheprasov.formulaone.features.drivers_list.data.repository_impl.DriversRepositoryImpl

val driversListDataModule = module {
    single<DriversRepository> {
        DriversRepositoryImpl(remoteApi = get())
    }
}