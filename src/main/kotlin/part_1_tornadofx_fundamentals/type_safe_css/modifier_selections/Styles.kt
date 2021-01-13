package part_1_tornadofx_fundamentals.type_safe_css.modifier_selections

import javafx.scene.paint.Color
import tornadofx.Stylesheet

class Styles: Stylesheet() {
    init {
        button{
            and(hover){
                backgroundColor += Color.RED
            }
        }

        cell{
            and(selected) {
                backgroundColor += Color.RED
            }
        }
    }
}