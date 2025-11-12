package yegor.cheprasov.formulaone.core.design.extensions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.Color
import yegor.cheprasov.formulaone.core.design.R
import yegor.cheprasov.formulaone.core.domein_models.enums.Command
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

fun Command.getRightCarImages(): Int = when(this) {
    Command.McLaren -> R.drawable.car_mclarencarright
    Command.Mercedes -> R.drawable.car_mercedescarright
    Command.RedBullRacing -> R.drawable.car_redbullracingcarright
    Command.Ferrari -> R.drawable.car_ferraricarright
    Command.Williams -> R.drawable.car_williamscarright
    Command.RacingBulls -> R.drawable.car_racingbullscarright
    Command.AstonMartin -> R.drawable.car_astonmartincarright
    Command.Haas -> R.drawable.car_haascarright
    Command.Sauber -> R.drawable.car_kicksaubercarright
    Command.Alpine -> R.drawable.car_alpinecarright
}

object CarBitmapsCache {

    private val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    private val bitmaps = mutableMapOf<Command, Bitmap>()

    fun preload(context: Context) {
        val density = context.resources.displayMetrics.density
        Command.entries.forEach { command ->
            executor.submit {
                val bitmap = decodeWebpScaled(context, command.getRightCarImages(), (250 * density).roundToInt())
                synchronized(CarBitmapsCache) {
                    bitmaps[command] = bitmap
                }
            }
        }

        executor.shutdown()
        executor.awaitTermination(10, TimeUnit.SECONDS)
    }

    fun decodeWebpScaled(context: Context, resId: Int, targetWidthPx: Int): Bitmap {
        val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeResource(context.resources, resId, options)

        val inSampleSize = (options.outWidth / targetWidthPx.toFloat()).roundToInt().coerceAtLeast(1)

        val finalOptions = BitmapFactory.Options().apply { this.inSampleSize = inSampleSize }
        return BitmapFactory.decodeResource(context.resources, resId, finalOptions)
    }

    fun get(command: Command): Bitmap = bitmaps[command]!!
}

fun Command.getColor(): Color =
    when(this) {
        Command.McLaren -> Color(0xFFF58020)
        Command.Mercedes -> Color(0xFF6CD3BF)
        Command.RedBullRacing -> Color(0xFF3671C6)
        Command.Ferrari -> Color(0xFFF91536)
        Command.Williams -> Color(0xFF37BEDD)
        Command.RacingBulls -> Color(0xFF5E93DE)
        Command.AstonMartin -> Color(0xFF358C75)
        Command.Sauber -> Color(0xFF64AB25)
        Command.Alpine -> Color(0xFF2293D1)
        Command.Haas -> Color(0xFF858585)
    }