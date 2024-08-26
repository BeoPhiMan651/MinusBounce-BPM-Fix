/*
 * MinusBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/MinusMC/MinusBounce
 */
package net.minusmc.minusbounce.features.module.modules.movement.speeds.other

import net.minusmc.minusbounce.features.module.modules.movement.speeds.SpeedMode
import net.minusmc.minusbounce.features.module.modules.movement.speeds.SpeedType
import net.minusmc.minusbounce.utils.player.MovementUtils.isMoving
import net.minusmc.minusbounce.utils.extensions.tryJump

class LegitSpeed: SpeedMode("LegitSpeed", SpeedType.OTHER) {
    override fun onUpdate() {
        val player = mc.thePlayer ?: return

        if (player.isInWater || player.isInLava || player.isInWeb || player.isOnLadder) return

        if (player.onGround && isMoving) {
            player.tryJump()
        }
    }
}