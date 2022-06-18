package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonLogin = findViewById<Button>(R.id.mainLoginButton)
        buttonLogin.setOnClickListener {
            val intent = Intent(this,  LoginActivity::class.java)
            startActivity(intent)
        }
        val buttonRegister = findViewById<Button>(R.id.mainRegisterButton)
        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        val buttonPlay = findViewById<Button>(R.id.mainPlayButton)
        buttonPlay.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
        val buttonHighScore = findViewById<Button>(R.id.mainHighScore)
        buttonHighScore.setOnClickListener {
            val intent = Intent(this, HighScoreActivity::class.java)
            startActivity(intent)
        }
    }
}