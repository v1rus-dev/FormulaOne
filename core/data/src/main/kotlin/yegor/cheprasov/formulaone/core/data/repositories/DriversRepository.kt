package yegor.cheprasov.formulaone.core.data.repositories

import yegor.cheprasov.formulaone.core.domein_models.entities.Driver

interface DriversRepository {
    suspend fun getDrivers(sessionId: Int): Result<List<Driver>>
}