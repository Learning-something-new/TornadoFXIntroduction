package basic_controls.builders

import javafx.scene.control.TextField
import tornadofx.*

class MyView : View() {

    var firstNameField: TextField by singleAssign()
    var lastNameField: TextField by singleAssign()

    override val root = vbox {
        hbox {
            label("First name")
            firstNameField = textfield()
        }
        hbox {
            label("Last name")
            lastNameField = textfield()
        }
        button("LOGIN") {
            useMaxWidth = true
            action { println("Logging in as ${firstNameField.text} ${lastNameField.text}") }
        }
    }
}

class MyApp : App(MyView::class)

fun main() {
    launch<MyApp>()
}