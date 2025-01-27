package tg.eplcoursandroid.covoiturage.service

import com.google.firebase.database.FirebaseDatabase
import tg.eplcoursandroid.covoiturage.models.Trajet

class TrajetService {

    fun ajouterTrajet(trajet: Trajet) {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("trajets/${trajet.idTrajet}")
        ref.setValue(trajet)
            .addOnSuccessListener {
                println("Trajet ajouté avec succès !")
            }
            .addOnFailureListener { e ->
                println("Erreur : ${e.message}")
            }
    }

    fun supprimerTrajet(idTrajet: String) {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("trajets/$idTrajet")
        ref.removeValue()
            .addOnSuccessListener {
                println("Trajet supprimé avec succès !")
            }
            .addOnFailureListener { e ->
                println("Erreur : ${e.message}")
            }
    }

    fun modifierTrajet(trajet: Trajet) {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("trajets/${trajet.idTrajet}")
        ref.setValue(trajet)
            .addOnSuccessListener {
                println("Trajet modifié avec succès !")
            }
            .addOnFailureListener { e ->
                println("Erreur : ${e.message}")
            }
    }

    fun trouverTrajet(idTrajet: String, callback: (Trajet?) -> Unit) {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("trajets/$idTrajet")
        ref.get().addOnSuccessListener { snapshot ->
            val trajet = snapshot.getValue(Trajet::class.java)
            callback(trajet)
        }.addOnFailureListener { e ->
            println("Erreur : ${e.message}")
            callback(null)
        }
    }

    fun listerTrajets(callback: (List<Trajet>) -> Unit) {
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("trajets")
        ref.get().addOnSuccessListener { snapshot ->
            val trajets = snapshot.children.mapNotNull { it.getValue(Trajet::class.java) }
            callback(trajets)
        }.addOnFailureListener { e ->
            println("Erreur : ${e.message}")
            callback(emptyList())
        }
    }
}