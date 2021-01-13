package part_1_tornadofx_fundamentals.type_safe_css.modifier_selections

import tornadofx.*

class ModifierApp: App(MyView::class, Styles::class)

class MyView: View(){
    private val listItems = listOf("Alpha", "Beta", "Gamma").asObservable()

    override val root = vbox {
        button("Hover over me"){
            action {
                listItems.add("Teta")
            }
        }
        listview(listItems)
    }
}