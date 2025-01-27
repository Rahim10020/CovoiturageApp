package tg.eplcoursandroid.covoiturage.models

data class Evaluation(
    val idConducteur: String,
    val idPassager: String,
    val note: Int,
    val commentaire: String
)