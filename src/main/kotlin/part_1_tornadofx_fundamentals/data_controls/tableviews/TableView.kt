package part_1_tornadofx_fundamentals.data_controls.tableviews

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.paint.Color
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class TableView : View() {

    private val persons = listOf(
        Person(1, "Samantha Stuart", LocalDate.of(1981, 12, 4)),
        Person(2, "Tom Marks", LocalDate.of(2001, 1, 23)),
        Person(3, "Stuart Gills", LocalDate.of(1989, 5, 23)),
        Person(4, "Nicole Williams", LocalDate.of(1998, 8, 11)),
        Person(5, "Eric Vog", LocalDate.of(2005, 7, 3))
    ).asObservable()

    private val personsProperties = listOf(
        PersonProperties(1, "Samantha Stuart", LocalDate.of(1981, 12, 4)),
        PersonProperties(2, "Tom Marks", LocalDate.of(2001, 1, 23)),
        PersonProperties(3, "Stuart Gills", LocalDate.of(1989, 5, 23)),
        PersonProperties(3, "Nicole Williams", LocalDate.of(1998, 8, 11)),
        PersonProperties(5, "Eric Vog", LocalDate.of(2005, 7, 3)),
        ).asObservable()

    //    override val root = tableview(persons) {
//        readonlyColumn("ID", Person::id)
//        readonlyColumn("Name", Person::name)
//        readonlyColumn("Birthday", Person::birthday)
//        readonlyColumn("Age", Person::age)
//    }
//
    override val root = tableview(personsProperties) {
        isEditable = true
        column("ID", PersonProperties::idProperty).makeEditable()
        column("Name", PersonProperties::nameProperty).makeEditable()
        column("Birthday", PersonProperties::birthdayProperty).makeEditable()
        readonlyColumn("Age", PersonProperties::age).cellFormat {
            text = it.toString()
            style {
//                backgroundColor += c("#8b0000")
//                textFill = Color.WHITE

                if (it!! < 18) {
                    backgroundColor += c("#8b0000")
                    textFill = Color.WHITE
                } else {
                    backgroundColor += Color.WHITE
                    textFill = Color.BLACK
                }
            }
        }
    }
}

class Person(var id: Int, var name: String, var birthday: LocalDate) {
    val age = Period.between(birthday, LocalDate.now()).years
}

class PersonProperties(id: Int, name: String, birthday: LocalDate) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty

    val birthdayProperty = SimpleObjectProperty(birthday)
    var birthday by birthdayProperty

    val ageProperty = birthdayProperty.objectBinding { Period.between(it, LocalDate.now()).years }
    val age by ageProperty
}

class MyApp : App(TableView::class)

fun main() {
    launch<MyApp>()
}