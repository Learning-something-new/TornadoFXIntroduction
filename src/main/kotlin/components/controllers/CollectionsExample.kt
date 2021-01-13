package components.controllers

import javafx.collections.FXCollections
import tornadofx.*


class MyListView: View() {
    val controller: MyListController by inject()

    override val root = vbox {
        label("My items")
        listview(controller.values)
    }
}

class MyListController: Controller() {
    val values = FXCollections.observableArrayList("Alpha", "Beta", "Gamma", "Delta")
}


class MyListApp : App(MyListView::class)

fun main() {
    launch<MyListApp>()
}