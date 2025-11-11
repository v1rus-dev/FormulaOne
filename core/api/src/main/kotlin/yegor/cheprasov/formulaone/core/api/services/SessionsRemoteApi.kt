package yegor.cheprasov.formulaone.core.api.services

import retrofit2.http.GET
import yegor.cheprasov.formulaone.core.api.entities.SessionEntity

interface SessionsRemoteApi {

    @GET("sessions")
    suspend fun sessions(): List<SessionEntity>
}