package type_safe_css.applying_style_classes_with_stylesheets

import javafx.scene.paint.Color
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.deg
import tornadofx.px

class MyStyle : Stylesheet() {

    companion object {

        private val topColor = Color.RED
        private val rightColor = Color.DARKGREEN
        private val leftColor = Color.ORANGE
        private val bottomColor = Color.PURPLE
    }

    init {
        s(button, label){
            fontSize = 20.px
        }

        button {
            rotate = 10.deg
            borderColor += box(topColor, rightColor, bottomColor, leftColor)
            fontFamily = "Comic Sans MS"
        }
    }
}