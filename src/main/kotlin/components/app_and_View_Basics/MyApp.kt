package components.app_and_View_Basics

import tornadofx.App
import tornadofx.launch

class MyApp: App(MyView::class)

fun main(args: Array<String>) {
    launch<MyApp>(args)
}