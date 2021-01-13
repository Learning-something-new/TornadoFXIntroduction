package part_1_tornadofx_fundamentals.components.fragment

import tornadofx.*


class MyView : View() {
    override val root = vbox {
        button("Press Me") {
            action {
                find<MyFragment>().openModal()
            }
        }
    }
}

class MyFragment: Fragment() {
    override val root = label("This is a popup")
}


class MyApp : App(MyView::class)

fun main() {
    launch<MyApp>()
}