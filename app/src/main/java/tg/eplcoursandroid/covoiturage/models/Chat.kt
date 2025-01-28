package tg.eplcoursandroid.covoiturage.models

data class Chat(
    val id: String = "",
    val driverId: String = "",
    val passengerId: String = "",
    val lastMessage: String = "",
    val timestamp: Long = 0L
)
