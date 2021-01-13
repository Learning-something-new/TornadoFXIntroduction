package part_1_tornadofx_fundamentals.basic_controls.builders_for_basic_controls

import javafx.application.Platform
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.ToggleGroup
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.TextAlignment
import tornadofx.*
import java.time.LocalDate
import kotlin.concurrent.thread

class MyView : View() {
    private val toggleGroup = ToggleGroup()
    private val radioGroup = ToggleGroup()

    override val root = hbox {
        vbox {
            button("Button") {
                textFill = Color.RED
//                useMaxWidth = true
                action {
                    println("Button pressed!")
                }
            }

            label {
                text = "Label"
                textFill = Color.BLUE
//                useMaxWidth = true
                textAlignment = TextAlignment.RIGHT //not work
            }


            textfield("Text field") {
                textProperty().addListener { observable, oldValue, newValue ->
                    println("You typed: $newValue")
                }
            }

            passwordfield("Password") {
                requestFocus()
            }


            val booleanProperty = SimpleBooleanProperty()
            checkbox("Checkbox", property = booleanProperty) {
                action { println("Checkbox is $isSelected") }
            }
            checkbox("Second checkbox", property = booleanProperty) {
                action { println("Checkbox is $isSelected") }
            }


            val texasCities = FXCollections.observableArrayList(
                "Austin",
                "Dallas", "Midland", "San Antonio", "Fort Worth"
            )

            val selectedCity = SimpleStringProperty()

            combobox(selectedCity, values = texasCities)
            label(selectedCity)


            togglebutton {
                val stateText = selectedProperty().stringBinding {
                    if (it == true) "ON" else "OFF"
                }
                textProperty().bind(stateText)
            }

            hbox {
                togglebutton("YES", toggleGroup)
                togglebutton("NO", toggleGroup)
                togglebutton("MAYBE", toggleGroup)
            }


            radiobutton("RadioButton") {
                action {
                    println("RadioButton is $isSelected")
                }
            }

            vbox {
                radiobutton("first", radioGroup)
                radiobutton("second", radioGroup)
                radiobutton("third", radioGroup)
            }


            val dateProperty = SimpleObjectProperty<LocalDate>()

            datepicker(dateProperty) {
                value = LocalDate.now()
            }

            textarea("Textarea") {
                selectAll()
            }
        }

        vbox {
            progressbar(0.4)

            progressbar {
                thread{
                    for (i in 1..100){
                        Platform.runLater { progress = i.toDouble() / 100.0 }
                        Thread.sleep(100)
                    }
                }
            }


            progressindicator {
                thread {
                    for (i in 1..100) {
                        Platform.runLater { progress = i.toDouble() / 100.0 }
                        Thread.sleep(100)
                    }
                }
            }
//
//            imageview("cat.jpg"){
//                scaleX = .3
//                scaleY = .3
//            }

            hyperlink("Hyper link"){action { println("Hyperlink action") }}

            text("One\nTwo\nThree") {
                fill = Color.AQUAMARINE
                font = Font(20.0)
            }

            textflow{
                text("Tornado"){
                    fill = Color.PURPLE
                    font = Font(20.0)
                }
                text("FX") {
                    fill = Color.ORANGE
                    font = Font(28.0)
                }
            }

            button("Commit") {
                tooltip("Writes input to the database"){
                    font = Font.font("Verdana")
                }
                action { println("Pressed $this") }
                shortcut("Ctrl+S")
            }



        }
    }

}

class MyApp : App(MyView::class)

fun main() {
    launch<MyApp>()
}