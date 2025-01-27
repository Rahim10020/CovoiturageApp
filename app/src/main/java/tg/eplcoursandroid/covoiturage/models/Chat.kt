package tg.eplcoursandroid.covoiturage.models

class Chat(
    val idChat: String,
    val idPassager: String,
    val idConducteur: String
) {
    // Envoyer un message
    fun envoyerMessage(message: String) {
        // Logique pour enregistrer un message dans Firebase Realtime Database
    }

    // Recevoir un message
    fun recevoirMessage(idChat: String) {
        // Logique pour récupérer les messages depuis Firebase
    }
}