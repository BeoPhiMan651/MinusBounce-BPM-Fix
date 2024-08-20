package net.minusmc.minusbounce.ui.gui.colortheme
import java.awt.Color
import net.minusmc.minusbounce.features.module.modules.render.CustomClientColor

object ClientTheme {
    fun getColorWithAlpha(index: Int, alpha: Int): Color {
        if (CustomClientColor.state) return CustomClientColor.getColor(alpha)
        return Color(-1)
    }
}