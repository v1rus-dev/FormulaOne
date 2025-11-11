package yegor.cheprasov.formulaone.core.data.repositoriesImpl

import yegor.cheprasov.formulaone.core.api.runApiRequest
import yegor.cheprasov.formulaone.core.api.services.SessionsRemoteApi
import yegor.cheprasov.formulaone.core.api.toKotlinResult
import yegor.cheprasov.formulaone.core.data.repositories.SessionsRepository
import yegor.cheprasov.formulaone.core.domein_models.entities.Session
import yegor.cheprasov.formulaone.core.mappers.toDomain

class SessionsRepositoryImpl(
    private val sessionsRemoteApi: SessionsRemoteApi
) : SessionsRepository {
    override suspend fun getSessions(): Result<List<Session>> = runApiRequest {
        sessionsRemoteApi.sessions().map { entity -> entity.toDomain() }
    }.toKotlinResult()

    override suspend fun getLastSession(): Result<Session> = runApiRequest {
        sessionsRemoteApi.sessions().map { entity -> entity.toDomain() }.last()
    }.toKotlinResult()
}