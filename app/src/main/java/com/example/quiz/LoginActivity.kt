package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val loginButton = findViewById<Button>(R.id.loginLoginButton)


        loginButton.setOnClickListener {
            makeLogin()
        }
    }

    private fun makeLogin() {
        val logUser = findViewById<EditText>(R.id.loginUserNameBox)
        val logPass = findViewById<EditText>(R.id.loginPasswordBox)
        val inputUser = logUser.text.toString()
        val inputPass = logPass.text.toString()

        auth.signInWithEmailAndPassword(inputUser, inputPass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext,"Login Successful", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else {
                    Toast.makeText(baseContext,"Login Failed", Toast.LENGTH_SHORT).show()
                }
            }



    }

}