package yegor.cheprasov.formulaone.features.settings.presentation.screen

import androidx.lifecycle.ViewModel
import timber.log.Timber

class SettingsViewModel : ViewModel() {
    init {
        Timber.tag("myTag").d("Init settings viewModel")
    }
}