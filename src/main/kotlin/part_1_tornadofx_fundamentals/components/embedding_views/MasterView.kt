package part_1_tornadofx_fundamentals.components.embedding_views

import tornadofx.*

class MasterView: View(){
    override val root = borderpane{
        top<TopView>()
        bottom<BottomView>()
    }
    
}

class TopView : View() {
    override val root = label("Top View")
}

class BottomView: View() {
    override val root = label("Bottom View")
}

class MyApp: App(MasterView::class)

fun main() {
    launch<MyApp>()
}
