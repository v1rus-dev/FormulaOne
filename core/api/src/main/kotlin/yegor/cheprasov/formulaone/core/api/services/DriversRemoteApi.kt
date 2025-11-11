package yegor.cheprasov.formulaone.core.api.services

import retrofit2.http.GET
import retrofit2.http.Query
import yegor.cheprasov.formulaone.core.api.entities.DriverEntity

interface DriversRemoteApi {

    @GET("drivers")
    suspend fun getDrivers(@Query("session_key") sessionKey: Int): List<DriverEntity>

    @GET("drivers")
    suspend fun getDriverInfo(
        @Query("driver_number") driverNumber: Int,
        @Query("session_key") sessionKey: Int
    ): List<DriverEntity>

}