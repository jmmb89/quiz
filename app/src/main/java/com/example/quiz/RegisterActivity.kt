package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val registerButton = findViewById<Button>(R.id.regButton)

        registerButton.setOnClickListener {
            signUp()
        }

        auth = Firebase.auth
    }

    private fun signUp() {
        val loginBox = findViewById<EditText>(R.id.regNameBox)
        val passBox = findViewById<EditText>(R.id.regPasswordBox)

        val inputLogin = loginBox.text.toString()
        val inputPass = passBox.text.toString()

        auth.createUserWithEmailAndPassword(inputLogin, inputPass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //sigin com sucesso
                    Toast.makeText(baseContext,"Authentication Successful", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else {
                    Toast.makeText(baseContext,"Authentication Failed", Toast.LENGTH_SHORT).show()
                }
            }

    }

}