package net.minusmc.minusbounce.features.module.modules.render

import net.minusmc.minusbounce.event.AttackEvent
import net.minusmc.minusbounce.event.EventTarget
import net.minusmc.minusbounce.features.module.Module
import net.minusmc.minusbounce.features.module.ModuleCategory
import net.minusmc.minusbounce.features.module.ModuleInfo
import net.minusmc.minusbounce.value.IntegerValue
import net.minusmc.minusbounce.value.BoolValue
import net.minecraft.entity.EntityLivingBase
import net.minecraft.util.EnumParticleTypes

@ModuleInfo(name = "MoreParticles", spacedName = "More Particles", description = "More Particles", category = ModuleCategory.RENDER)
class MoreParticles : Module() {
    private val timesValue = IntegerValue("Times", 1, 1, 10)
    private val sharpness = BoolValue("FakeSharp", false)

    @EventTarget
    fun onAttack(event: AttackEvent) {
        displayEffectFor(event.targetEntity as EntityLivingBase)
    }

    private fun displayEffectFor(entity: EntityLivingBase) {
        repeat(timesValue.get()) {
            if (sharpness.get()) {
                mc.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.CRIT_MAGIC)
            }
            mc.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.CRIT)
        }
    }
}