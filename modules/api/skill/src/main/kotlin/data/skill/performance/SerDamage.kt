package data.skill.performance

data class SerDamage(
    val amount: Double,
    val ignoreResistance: Boolean,
    val element: Element,
    val delay: Int
)
