package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill

interface ISkillService {
    fun onRightClick()
    fun onLeftClick() 
    fun onShiftChange()
    fun onJump()
    fun onSprint()
    fun onDamage()
    fun onKill()
    fun onDeath()
}