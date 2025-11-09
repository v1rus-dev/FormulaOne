package yegor.cheprasov.formulaone.features.home.presentation.screen

import androidx.lifecycle.ViewModel
import timber.log.Timber

class HomeViewModel : ViewModel() {

    init {
        Timber.tag("myTag").d("Init home viewModel")
    }

}