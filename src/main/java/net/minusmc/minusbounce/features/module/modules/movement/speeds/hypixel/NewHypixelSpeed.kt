
package net.minusmc.minusbounce.features.module.modules.movement.speeds.hypixel

import net.minusmc.minusbounce.features.module.modules.movement.speeds.SpeedMode
import net.minusmc.minusbounce.features.module.modules.movement.speeds.SpeedType
import net.minusmc.minusbounce.utils.player.MovementUtils.isMoving
import net.minusmc.minusbounce.utils.player.MovementUtils.strafe
import net.minusmc.minusbounce.utils.extensions.tryJump

class NewHypixelSpeed : SpeedMode("NewHypixelSpeed", SpeedType.HYPIXEL) {
    override fun onUpdate() {
        val player = mc.thePlayer ?: return
        if (player.isInWater || player.isInLava || player.isInWeb || player.isOnLadder) return

        if (isMoving) {
            if (player.isAirBorne && player.fallDistance > 2) {
                mc.timer.timerSpeed = 1f
                return
            }

            if (player.onGround) {
                player.tryJump()
                if (player.motionY > 0) {
                    mc.timer.timerSpeed = 1.1453f
                }
                strafe(0.4815f)
            } else {
                if (player.motionY < 0) {
                    mc.timer.timerSpeed = 0.9185f
                }
            }
        } else {
            mc.timer.timerSpeed = 1f
        }
    }
}