package type_safe_css

import tornadofx.App
import tornadofx.launch
import type_safe_css.inline_css.InlineCss
import type_safe_css.modifier_selections.ModifierApp


class InlineApp: App(InlineCss::class)


fun main() {
    launch<ModifierApp>()
}