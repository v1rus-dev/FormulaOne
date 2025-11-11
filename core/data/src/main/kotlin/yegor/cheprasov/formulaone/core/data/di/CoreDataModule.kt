package yegor.cheprasov.formulaone.core.data.di

import org.koin.dsl.module
import yegor.cheprasov.formulaone.core.data.repositories.SessionsRepository
import yegor.cheprasov.formulaone.core.data.repositoriesImpl.SessionsRepositoryImpl

val coreDataModule = module {
    single<SessionsRepository> {
        SessionsRepositoryImpl(
            sessionsRemoteApi = get()
        )
    }
}