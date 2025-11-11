package yegor.cheprasov.formulaone.core.data.repositories

import yegor.cheprasov.formulaone.core.domein_models.entities.Session

interface SessionsRepository {

    suspend fun getSessions(): Result<List<Session>>

    suspend fun getLastSession(): Result<Session>

}