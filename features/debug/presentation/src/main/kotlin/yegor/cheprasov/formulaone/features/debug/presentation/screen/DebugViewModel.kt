package yegor.cheprasov.formulaone.features.debug.presentation.screen

import android.util.Log
import androidx.lifecycle.ViewModel

class DebugViewModel : ViewModel() {
    init {
        Log.d("myTag", "Init debug view model")
    }
}