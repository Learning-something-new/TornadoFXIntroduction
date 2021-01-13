package layouts_and_menus

import javafx.scene.control.TextFormatter
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import tornadofx.*

class Boxes : View() {
    override val root = vbox {
        button("Button 1") {
            vboxConstraints {
                marginBottom = 20.0
                vGrow = Priority.ALWAYS
            }
        }
        button("Button 2").setOnAction {
            println("Button 2 Pressed")
        }
    }
}

class FlowPane : View() {
    override val root = flowpane {
        for (i in 1..100) {
            button(i.toString()) {
                setOnAction { println("You pressed button $i") }
            }
        }
    }
}

class BorderPane : View() {
    override val root = borderpane {
        top = label("TOP") {
            useMaxWidth = true
            useMaxHeight = true
            style {
                backgroundColor += Color.RED
            }
        }

        bottom = label("BOTTOM") {
            useMaxWidth = true
            useMaxHeight = true
            style {
                backgroundColor += Color.BLUE
            }
        }

        left = label("LEFT") {
            useMaxWidth = true
            useMaxHeight = true
            style {
                backgroundColor += Color.GREEN
            }
        }

        right = label("RIGHT") {
            useMaxWidth = true
            useMaxHeight = true
            style {
                backgroundColor += Color.PURPLE
            }
        }

        center = label("CENTER") {
            useMaxWidth = true
            useMaxHeight = true
            style {
                backgroundColor += Color.YELLOW
            }
        }
    }
}

class FormBuilder: View(){
    override val root = form {
        fieldset("Personal Info") {
            field("First Name") {
                textfield()
            }
            field("Last Name") {
                textfield()
            }
            field("Birthday") {
                datepicker()
            }
        }
        fieldset("Contact") {
            field("Phone") {
                textfield()
            }
            field("Email") {
                textfield()
            }
        }
        button("Commit") {
            action { println("Wrote to database!")}
        }
    }
}

class NestingForm: View(){
    override val root = form {
        hbox(20) {
            fieldset("Left FieldSet") {
                hbox(20) {
                    vbox {
                        field("Field l1a") { textfield {filterInput(FirstTenFilter)} }
                        field("Field l2a") { textfield() }
                    }
                    vbox {
                        field("Field l1b") { textfield() }
                        field("Field l2b") { textfield() }
                    }
                }
            }
            fieldset("Right FieldSet") {
                hbox(20) {
                    vbox {
                        field("Field r1a") { textfield() }
                        field("Field r2a") { textfield() }
                    }
                    vbox {
                        field("Field r1b") { textfield() }
                        field("Field r2b") { textfield() }
                    }
                }
            }
        }
    }
}

val FirstTenFilter: (TextFormatter.Change) -> Boolean = { change ->
    !change.isAdded || change.controlNewText.let {
        it.isInt() && it.toInt() in 0..10
    }
}

class LayoutsApp : App(NestingForm::class)

fun main() {
    launch<LayoutsApp>()
}