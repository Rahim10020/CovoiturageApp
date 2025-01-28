package tg.eplcoursandroid.covoiturage

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import tg.eplcoursandroid.covoiturage.models.Conducteur
import tg.eplcoursandroid.covoiturage.models.Passager
import tg.eplcoursandroid.covoiturage.models.Utilisateur
import tg.eplcoursandroid.covoiturage.service.AuthService
import tg.eplcoursandroid.covoiturage.service.ConducteurService
import tg.eplcoursandroid.covoiturage.service.PassagerService
import tg.eplcoursandroid.covoiturage.service.UtilisateurService

class MainActivity : AppCompatActivity() {

    private val authService = AuthService()
    private val passagerService = PassagerService()
    private val utilisateurService = UtilisateurService()
    private val conducteurService = ConducteurService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        authService.deconnecter()

        // methode pour inscrire un salaud
//        authService.inscrire("crepin@gmail.com", "fuckEPLforLife") { success, message ->
//            if (success) {
//                Log.d("Inscrire", "crepin inscrit")
//            } else {
//                Log.d("Inscrire", "crepin non inscrit")
//            }
//        }

        authService.connecter("rahim@gmail.com", "rahimForLife") { success, message ->
            if (success) {
                Log.d("Inscrire", "rahim connecte");
            } else {
                Log.d("Inscrire", "rahim non connecte")
            }
        }


        val currentUser = authService.getCurrentUser()
        if (currentUser != null) {
            Log.d("ChatApp", "Utilisateur connecté : ${currentUser.email}")
        } else {
            Log.d("ChatApp", "Aucun utilisateur connecté.")
        }

        // creation d'un utilisateur qui est celui actuellement connecte
        val utilisateur = Utilisateur(currentUser!!.uid, currentUser.email, currentUser.displayName)
        utilisateurService.ajouterUtilisateur(utilisateur,onSuccess = {
            Log.d("MainActivity", "Utilisateur ajouté avec succès !")
        },
            onFailure = { exception ->
                Log.e("MainActivity", "Erreur lors de l'ajout de l'utilisateur : ${exception.message}")
            })

//        // creation d'un passager
//        val passager = Passager(utilisateur, "crepin")
//        passagerService.ajouterPassager(passager,onSuccess = {
//            Log.d("MainActivity", "Passager ajouté avec succès !")
//        },
//            onFailure = { exception ->
//                Log.e("MainActivity", "Erreur lors de l'ajout du passager : ${exception.message}")
//            })

        // creation d'un conducteur
//        val conducteur = Conducteur(utilisateur, "RahimBro", "Toyota")
//        conducteurService.ajouterConducteur(conducteur)

    }
}