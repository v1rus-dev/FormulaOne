package yegor.cheprasov.formulaone.logging

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber
import yegor.cheprasov.formulaone.BuildConfig

class TimberInitializer : Initializer<List<Timber.Tree>> {
    override fun create(context: Context): List<Timber.Tree> {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        return Timber.forest()
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> = emptyList()
}