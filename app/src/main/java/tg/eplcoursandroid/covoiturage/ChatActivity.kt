package tg.eplcoursandroid.covoiturage

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.ServerValue
import com.google.firebase.database.database

class ChatActivity : AppCompatActivity() {

    val database = Firebase.database.reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_chat)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // enregistrer le message dans la base de donnees quand l'utilisateur clique sur le bouton
        val messageInput = findViewById<EditText>(R.id.messageInput)
        val sendButton = findViewById<ImageButton>(R.id.sendButton)

//        sendButton.setOnClickListener {
//            val messageText = messageInput.text.toString()
//            if (messageText.isNotEmpty()) {
//                val message = hashMapOf(
//                    "text" to messageText,
//                    "sender" to Firebase.auth.currentUser?.uid,
//                    "timestamp" to ServerValue.TIMESTAMP
//                )
//                database.child("chats").child(chatId).child("messages").push().setValue(message)
//                messageInput.text.clear()
//            }
//        }

    }
}