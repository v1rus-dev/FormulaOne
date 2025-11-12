package yegor.cheprasov.formulaone

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import yegor.cheprasov.formulaone.core.design.extensions.CarBitmapsCache

class App : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())


    override fun onCreate() {
        super.onCreate()
    }

//    private fun preloadImages() = applicationScope.launch(Dispatchers.Default) {
//        CarBitmapsCache.preload(this@App)
//    }

}