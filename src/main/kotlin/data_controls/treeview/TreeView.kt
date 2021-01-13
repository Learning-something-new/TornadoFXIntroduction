package data_controls.treeview

import javafx.scene.control.TreeItem
import tornadofx.*

class TreeView: View() {
    val persons = listOf(
        Person("Mary Hanes","Marketing"),
        Person("Steve Folley","Customer Service"),
        Person("John Ramsy","IT Help Desk"),
        Person("Erlick Foyes","Customer Service"),
        Person("Erin James","Marketing"),
        Person("Jacob Mays","IT Help Desk"),
        Person("Larry Cable","Customer Service")
    )

    val departments = persons
        .map { it.department }
        .distinct().map { Person(it, "") }

    override val root = treeview<Person>{
        root = TreeItem(Person("Departments", ""))

        cellFormat { text = it.name }

        populate { parent ->
            if (parent == root) departments else persons.filter { it.department == parent.value.name }
        }
    }
}

data class Person(val name: String, val department: String)

class MyApp: App(TreeView::class)

fun main() {
    launch<MyApp>()
}