package tg.eplcoursandroid.covoiturage.models

data class Chat(
    val id: String = "",
    val conducteurId: String = "",
    val passagerId: String = "",
    val dernierMessage: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
