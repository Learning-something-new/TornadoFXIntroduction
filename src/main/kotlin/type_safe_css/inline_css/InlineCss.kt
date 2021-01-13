package type_safe_css.inline_css

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class InlineCss : View() {
    override val root = hbox {
        button("Press me") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                borderColor += box(
                    top = Color.RED,
                    bottom = Color.DARKOLIVEGREEN,
                    right = Color.BISQUE,
                    left = Color.TEAL
                )

                rotate = 45.deg
            }

            setOnAction {
                println("Button pressed")
            }
        }
    }

}