package tg.eplcoursandroid.covoiturage.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthService {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    // Inscription d'un utilisateur
    fun inscrire(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Inscription réussie
                    onComplete(true, "Inscription réussie!")
                } else {
                    // Erreur lors de l'inscription
                    val errorMessage = task.exception?.message ?: "Erreur inconnue"
                    onComplete(false, errorMessage)
                }
            }
    }

    // Connexion d'un utilisateur
    fun connecter(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Connexion réussie
                    onComplete(true, "Connexion réussie!")
                } else {
                    // Erreur lors de la connexion
                    val errorMessage = task.exception?.message ?: "Erreur inconnue"
                    onComplete(false, errorMessage)
                }
            }
    }

    // Récupérer l'utilisateur actuel
    fun getCurrentUser(): FirebaseUser? {
        return mAuth.currentUser
    }

    // Déconnexion
    fun deconnecter() {
        mAuth.signOut()
    }

    // Vérifier si un utilisateur est connecté
    fun isUserLoggedIn(): Boolean {
        return mAuth.currentUser != null
    }
}
