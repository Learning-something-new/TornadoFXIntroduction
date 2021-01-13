package type_safe_css.nesting_styles

import tornadofx.*

class NestingStyleApp : App(MyView::class, MyStyle::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}

class MyView : View() {
    override val root = hbox {
        addClass(MyStyle.critical)
        button("Warning!"){addClass(MyStyle.critical)}
        button("Danger!"){addClass(MyStyle.critical)}
    }

}