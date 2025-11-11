package yegor.cheprasov.formulaone.features.drivers_list.data.repository_impl

import yegor.cheprasov.formulaone.core.api.runApiRequest
import yegor.cheprasov.formulaone.core.api.services.DriversRemoteApi
import yegor.cheprasov.formulaone.core.api.toKotlinResult
import yegor.cheprasov.formulaone.core.data.repositories.DriversRepository
import yegor.cheprasov.formulaone.core.domein_models.entities.Driver
import yegor.cheprasov.formulaone.core.mappers.toDomainOrNull

internal class DriversRepositoryImpl(
    private val remoteApi: DriversRemoteApi
) : DriversRepository {
    override suspend fun getDrivers(sessionId: Int): Result<List<Driver>> = runApiRequest {
        remoteApi.getDrivers(sessionId).mapNotNull {
            it.toDomainOrNull()
        }
    }.toKotlinResult()
}