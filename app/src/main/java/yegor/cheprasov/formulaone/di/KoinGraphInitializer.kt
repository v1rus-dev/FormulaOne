package yegor.cheprasov.formulaone.di

import android.content.Context
import androidx.startup.Initializer
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import yegor.cheprasov.formulaone.di.modules.viewModesModule

class KoinGraphInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        return startKoin {
            androidContext(context)
            modules(viewModesModule)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> = emptyList()
}