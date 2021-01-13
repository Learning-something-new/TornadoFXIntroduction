package type_safe_css.applying_style_classes_with_stylesheets

import javafx.scene.paint.Color
import tornadofx.*

class StyleExampleApp : App(MyView::class, MyStyle::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}

class MyView : View() {
    override val root = vbox {
        label("Lorem Ipsum")
        button("Press Me")
        button("Press Me Too")

        label("Lore Ipsum") {
            style {
                fontSize = 30.px
                backgroundColor = multi(Color.RED, Color.BLUE, Color.YELLOW)
                backgroundInsets = multi(box(4.px), box(8.px), box(12.px))
            }
        }

//        children.filter { it is Button }.addClass(MyStyle.tackyButton)
    }
}