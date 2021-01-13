package part_1_tornadofx_fundamentals.type_safe_css

import part_1_tornadofx_fundamentals.type_safe_css.inline_css.InlineCss
import part_1_tornadofx_fundamentals.type_safe_css.modifier_selections.ModifierApp
import tornadofx.App
import tornadofx.launch


class InlineApp: App(InlineCss::class)


fun main() {
    launch<ModifierApp>()
}