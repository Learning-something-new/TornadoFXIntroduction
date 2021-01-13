package type_safe_css.nesting_styles

import javafx.scene.paint.Color
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class MyStyle: Stylesheet(){
    companion object {
        val critical by cssclass()
    }

    init {
        critical{
            borderColor += box(Color.ORANGE)
            padding = box(5.px)

            and(button) {
                backgroundColor += Color.RED
                textFill = Color.WHITE
            }
        }
    }
}