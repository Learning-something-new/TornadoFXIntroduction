package shapes_and_animation.shapes

import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.shape.ArcType
import tornadofx.*

class MyView: View() {

    override val root =  stackpane {
        group {
            rectangle{
                fill = Color.RED
                width = 300.0
                height = 150.0
                arcWidth = 20.0
                arcHeight = 20.0
            }
            arc {
                centerX = 200.0
                centerY = 200.0
                radiusX = 50.0
                radiusY = 50.0
                startAngle = 45.0
                length = 250.0
                type = ArcType.ROUND
            }
            circle {
                centerX = 100.0
                centerY = 300.0
                radius = 50.0
            }
            line {
                startX = 50.0
                startY = 50.0
                endX = 150.0
                endY = 100.0
            }

            svgpath("M70,50 L90,50 L120,90 L150,50 L170,50 L210,90 L180,120 L170,110 L170,200 L70,200 L70,110 L60,120 L30,90 L70,50") {
                stroke = Color.DARKGREY
                strokeWidth = 2.0
                effect = DropShadow()
            }
        }
    }

}


class ShapeApp : App(MyView::class)


fun main() {
    launch<ShapeApp>()
}
