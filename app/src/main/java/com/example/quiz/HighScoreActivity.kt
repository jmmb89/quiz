package com.example.quiz
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database


class HighScoreActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        val session = auth.currentUser
        var nome = session?.email

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)
        val scoreLabel = findViewById<TextView>(R.id.hsScore)
        var score = intent.getIntExtra("score", 0)
        scoreLabel.text = "Score: " + "$score"
        //writescore(score.toString(), nome.toString())
    }

    fun writescore(score: String, nome: String) {

        //val db = Firebase.database
        //lateinit var database: DatabaseReference
        //val data = Ls (nome, score)
        //database = Firebase.database.reference
        //database.child("leaderboard").child(id).setValue(data)
        //val leaderboard = database.getReference("message")
        //leaderboard.setValue(score, nome)
    }
    data class Ls (val email: String? = null, val score: String? = null) {

    }

}