package components.controllers

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MyView : View() {
    val controller: MyController by inject()
    val input = SimpleStringProperty()

    override val root = form {
        fieldset {
            field("Input") {
                textfield(input)
            }

            button("Commit") {
                action {
                    input.value?.let {
                        if (it.isNotEmpty()) {
                            controller.writeToDb(input.value)
                            input.value = ""
                        }
                    }
                }
            }
        }
    }
}


class MyController : Controller() {
    fun writeToDb(inputValue: String) {
        println("Writing $inputValue to database!")
    }
}

class MyApp : App(MyView::class)

fun main() {
    launch<MyApp>()
}
