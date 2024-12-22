package data.skill

data class SerSkillSet (
    val relations: LinkedHashSet<List<String>> = linkedSetOf(),
    val skills: Map<SkillTrigger, Set<String>> = mapOf()
)