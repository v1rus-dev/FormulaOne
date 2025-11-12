package yegor.cheprasov.formulaone.imageLoader

import android.content.Context
import androidx.startup.Initializer
import yegor.cheprasov.formulaone.core.design.extensions.CarBitmapsCache

class ImageLoaderInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        CarBitmapsCache.preload(context = context)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> = emptyList()
}