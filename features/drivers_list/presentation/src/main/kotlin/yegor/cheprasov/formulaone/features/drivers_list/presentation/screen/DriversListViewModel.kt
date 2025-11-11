package yegor.cheprasov.formulaone.features.drivers_list.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber
import yegor.cheprasov.formulaone.core.data.repositories.DriversRepository
import yegor.cheprasov.formulaone.core.data.repositories.SessionsRepository
import yegor.cheprasov.formulaone.core.domein_models.entities.Session

class DriversListViewModel(
    private val driversRepository: DriversRepository,
    private val sessionsRepository: SessionsRepository
) : ViewModel() {

    init {
        getLastSession()
    }

    private fun getLastSession() = viewModelScope.launch {
        val session: Result<Session> = sessionsRepository.getLastSession()
        session.onSuccess {
            getDrivers(sessionId = it.sessionKey)
        }
    }

    private fun getDrivers(sessionId: Int) = viewModelScope.launch {
        val drivers = driversRepository.getDrivers(sessionId = sessionId)
        drivers.onSuccess {
            Timber.tag("myTag").d("Drivers getting success size: ${it.size}")
        }.onFailure {
            Timber.tag("myTag").d("Fail getting drivers: $it")
        }
    }

}