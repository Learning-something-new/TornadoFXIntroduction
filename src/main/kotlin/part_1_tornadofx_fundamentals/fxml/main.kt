package part_1_tornadofx_fundamentals.fxml

import tornadofx.App
import tornadofx.launch

class CounterApp : App(CounterView::class)


fun main() {
    launch<CounterApp>()
}