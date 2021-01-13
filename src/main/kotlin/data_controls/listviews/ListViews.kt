package data_controls.listviews

import javafx.scene.control.SelectionMode
import tornadofx.*


class ListView: View(){

    val greekLetters = listOf("Alpha","Beta",
        "Gamma","Delta","Epsilon").asObservable()

    override val root = listview(greekLetters) {
        selectionModel.selectionMode = SelectionMode.MULTIPLE
    }
}

class MyApp : App(ListView::class)

fun main() {
    launch<MyApp>()
}