/*
 * MinusBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/MinusMC/MinusBounce
 */
package net.minusmc.minusbounce.features.module.modules.render

import net.minusmc.minusbounce.features.module.Module
import net.minusmc.minusbounce.features.module.ModuleCategory
import net.minusmc.minusbounce.features.module.ModuleInfo
import net.minusmc.minusbounce.value.IntegerValue
import java.awt.Color

@ModuleInfo(name = "beophimandz", spacedName = "beophiman dz", description = "beophiman dz.", category = ModuleCategory.RENDER)
object CustomClientColor : Module() {
    private val redValue = IntegerValue("Red", 255,0,255)
    private val greenValue = IntegerValue("Green", 255,0,255)
    private val blueValue = IntegerValue("Blue", 255,0,255)

    fun getColor() : Color {
        return Color(redValue.get(), greenValue.get(), blueValue.get())
    }
    fun getColor(alpha : Int) : Color {
        return Color(redValue.get(), greenValue.get(), blueValue.get(), alpha)
    }
}