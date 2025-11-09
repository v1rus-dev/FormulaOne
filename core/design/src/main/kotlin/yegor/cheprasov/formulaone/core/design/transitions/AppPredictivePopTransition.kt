package yegor.cheprasov.formulaone.core.design.transitions

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.navigation3.scene.Scene
import androidx.navigationevent.NavigationEvent

fun <T : Any> appPredictivePopTransitionSpec():
        AnimatedContentTransitionScope<Scene<T>>.(@NavigationEvent.SwipeEdge Int) -> ContentTransform =
    { swipeEdge ->
        val slideDirection = when (swipeEdge) {
            NavigationEvent.EDGE_LEFT -> AnimatedContentTransitionScope.SlideDirection.Right
            NavigationEvent.EDGE_RIGHT -> AnimatedContentTransitionScope.SlideDirection.Left
            else -> AnimatedContentTransitionScope.SlideDirection.Right
        }

        ContentTransform(
            targetContentEnter = fadeIn(
                animationSpec = tween(
                    durationMillis = 450,
                    easing = LinearOutSlowInEasing
                ),
                initialAlpha = 0.6f
            ),
            initialContentExit =
                slideOutOfContainer(
                    towards = slideDirection,
                    animationSpec = tween(
                        durationMillis = 450,
                        easing = FastOutSlowInEasing
                    )
                ) +
                        scaleOut(
                            targetScale = 0.9f,
                            animationSpec = tween(
                                durationMillis = 450,
                                easing = FastOutSlowInEasing
                            )
                        ) +
                        fadeOut(
                            animationSpec = tween(
                                durationMillis = 450,
                                easing = LinearOutSlowInEasing
                            ),
                            targetAlpha = 0.6f
                        )
        )
    }