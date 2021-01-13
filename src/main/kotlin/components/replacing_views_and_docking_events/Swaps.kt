package components.replacing_views_and_docking_events

import tornadofx.*


class MyView1: View() {
    override val root = vbox {
        button("Go to MyView2") {
            action {
                replaceWith(MyView2::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
            }
        }
    }

    override fun onDock() {
        println("Docking MyView1!")
    }

    override fun onUndock() {
        println("Undocking MyView1!")
    }
}

class MyView2: View() {
    override val root = vbox {
        button("Go to MyView1") {
            action {
                replaceWith<MyView1>()
            }
        }
    }


    override fun onDock() {
        println("Docking MyView2!")
    }

    override fun onUndock() {
        println("Undocking MyView2!")
    }
}

class MyApp : App(MyView1::class)

fun main() {
    launch<MyApp>()
}