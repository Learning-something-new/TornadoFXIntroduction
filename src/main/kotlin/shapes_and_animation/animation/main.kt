package shapes_and_animation.animation

import javafx.animation.Interpolator
import javafx.geometry.Insets
import javafx.util.Duration
import tornadofx.*

class MyView : View() {

    override val root = stackpane {
        group {
            val rectangle = rectangle(width = 60.0,height = 40.0) {
                padding = Insets(20.0)
            }
            timeline {
                keyframe(Duration.seconds(5.0)) {
                    keyvalue(rectangle.rotateProperty(), 180.0, interpolator = Interpolator.EASE_BOTH)
                }
                isAutoReverse = true
                cycleCount = 3
            }

            rectangle(100, 200, 150, 50){
                padding = Insets(30.0)
                rotateProperty().animate(180.0, duration = 5.seconds)
            }
        }
    }
}

class AnimationApp : App(MyView::class)


fun main() {
    launch<AnimationApp>()
}
