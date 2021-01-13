package part_1_tornadofx_fundamentals.components.app_and_View_Basics

import tornadofx.View
import tornadofx.button
import tornadofx.label
import tornadofx.vbox

class MyView: View() {
    override val root = vbox{
        button("Press me")
        label("Waiting")
    }

}
