package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizActivity : AppCompatActivity() {
    private var currentQues = 0
    private var currentOpt = 0
    private var score = 0
    private var canIClick = true

    //private val imgPath = listOf("@drawable/mano_brown", "path2", "path3", "path4", "path5", "path6", "path7", "path8", "path9", "path10")
    //private val questions = listOf("Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10")
    private val ans1 = listOf("ice blue", "professor girafales", "lee van cleef",   "santana",         "jo soares",       "frank zappa",     "belchior",      "picasso", "don pedro", "Syd Barret")
    private val ans2 = listOf("tupac shakur","seu jaiminho",     "clint eastwood",  "freddie mercury", "stalin",          "tony iommi",      "zack wild",     "salvador dali", "charles bronson", "Roger Waters")
    private val ans3 = listOf("mano brown", "senhor barriga",    "eli wallach",     "brian may",       "stephen hawking", "zack wild",       "tony iommi",    "van gogh", "seu madruga", "David Gilmour")
    private val ans4 = listOf("sabotage",   "senhor furtado",    "el indio",        "raul seixas",     "george harrison", "john lenon",      "john travolta", "monet", "lemmy", "Nick Mason")
    private val ans5 = listOf("will smith", "seu madruga",       "charles bronson", "belchior",        "einstein",        "freddie mercury", "lula",          "da vinci", "john lenon", "Richard Wright")
    private val correct = listOf(3, 5, 1, 2, 5, 1, 3, 2, 4, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val progressBar = findViewById<ProgressBar>(R.id.quizProgressBar)
        val giveUpButton = findViewById<Button>(R.id.quizButtonGiveUp)
        val nextButton = findViewById<Button>(R.id.quizButtonNext)
        val opt1 = findViewById<TextView>(R.id.quizAns1)
        val opt2 = findViewById<TextView>(R.id.quizAns2)
        val opt3 = findViewById<TextView>(R.id.quizAns3)
        val opt4 = findViewById<TextView>(R.id.quizAns4)
        val opt5 = findViewById<TextView>(R.id.quizAns5)

        progressBar.progress = currentQues*10

        updateScreen()

        giveUpButton.setOnClickListener {
            updateScore()
            endGame()
        }

        nextButton.setOnClickListener {

            if (nextButton.text == "proxima") {
                if (currentQues > 8) {
                    nextButton.text = "fim"
                    canIClick = true
                }
                else {
                    nextButton.text = "enviar"
                    canIClick = true
                }

                updateScreen()
            }
            else {
                if (nextButton.text == "enviar") {
                    nextButton.text = "proxima"
                    showCorrectAnswer()
                    updateScore()
                    canIClick = false
                }
                else {
                    updateScore()
                    endGame()
                }
            }

        }

        opt1.setOnClickListener {
            if (canIClick) {
                defaultOptions()
                opt1.setBackgroundColor(Color.parseColor("#000099"))
                currentOpt = 1
            }
        }

        opt2.setOnClickListener {
            if (canIClick) {
                defaultOptions()
                opt2.setBackgroundColor(Color.parseColor("#000099"))
                currentOpt = 2
            }
        }

        opt3.setOnClickListener {
            if (canIClick) {
                defaultOptions()
                opt3.setBackgroundColor(Color.parseColor("#000099"))
                currentOpt = 3
            }
        }

        opt4.setOnClickListener {
            if (canIClick) {
                defaultOptions()
                opt4.setBackgroundColor(Color.parseColor("#000099"))
                currentOpt = 4
            }
        }

        opt5.setOnClickListener {
            if (canIClick) {
                defaultOptions()
                opt5.setBackgroundColor(Color.parseColor("#000099"))
                currentOpt = 5
            }
        }

    }

    private fun showCorrectAnswer() {
        defaultOptions()
        val opt1 = findViewById<TextView>(R.id.quizAns1)
        val opt2 = findViewById<TextView>(R.id.quizAns2)
        val opt3 = findViewById<TextView>(R.id.quizAns3)
        val opt4 = findViewById<TextView>(R.id.quizAns4)
        val opt5 = findViewById<TextView>(R.id.quizAns5)
        //muda o fundo pra verde caso tenha input
        if (currentOpt != 0) {
            when(correct[currentQues-1]) {
                1 -> opt1.setBackgroundColor(Color.parseColor("#00CC0C"))
                2 -> opt2.setBackgroundColor(Color.parseColor("#00CC0C"))
                3 -> opt3.setBackgroundColor(Color.parseColor("#00CC0C"))
                4 -> opt4.setBackgroundColor(Color.parseColor("#00CC0C"))
                5 -> opt5.setBackgroundColor(Color.parseColor("#00CC0C"))
            }
        }
        //se errar muda o fundo pra vermelho
        if (currentOpt != correct[currentQues-1]) {
            when(currentOpt) {
                1 -> opt1.setBackgroundColor(Color.parseColor("#FF0000"))
                2 -> opt2.setBackgroundColor(Color.parseColor("#FF0000"))
                3 -> opt3.setBackgroundColor(Color.parseColor("#FF0000"))
                4 -> opt4.setBackgroundColor(Color.parseColor("#FF0000"))
                5 -> opt5.setBackgroundColor(Color.parseColor("#FF0000"))
            }
        }
    }

    private fun updateScore() {
        if (currentOpt == correct[currentQues-1]) {
            score += 10
        }
    }

    private fun endGame() {
        val intent = Intent(this, HighScoreActivity::class.java).also {
            it.putExtra("score", score)
            startActivity(it)
        }
    }

    private fun updateScreen() {
        val progressBar = findViewById<ProgressBar>(R.id.quizProgressBar)
        val pBCount = findViewById<TextView>(R.id.quizPBCount)
        val questionImg = findViewById<ImageView>(R.id.quizImage)
        val opt1 = findViewById<TextView>(R.id.quizAns1)
        val opt2 = findViewById<TextView>(R.id.quizAns2)
        val opt3 = findViewById<TextView>(R.id.quizAns3)
        val opt4 = findViewById<TextView>(R.id.quizAns4)
        val opt5 = findViewById<TextView>(R.id.quizAns5)

        if (currentQues == 10) {
            endGame()
        }
        else {
            defaultOptions()
            currentOpt = 0
            currentQues += 1
            progressBar.progress = currentQues * 10
            pBCount.text = "$currentQues" + "/10"

            opt1.text = ans1[currentQues-1]
            opt2.text = ans2[currentQues-1]
            opt3.text = ans3[currentQues-1]
            opt4.text = ans4[currentQues-1]
            opt5.text = ans5[currentQues-1]

            when (currentQues) {
                1 -> questionImg.setImageResource(R.drawable.mano_brown)
                2 -> questionImg.setImageResource(R.drawable.seu_madruga)
                3 -> questionImg.setImageResource(R.drawable.lee_van_cleef)
                4 -> questionImg.setImageResource(R.drawable.freddie_mercury)
                5 -> questionImg.setImageResource(R.drawable.einstein)
                6 -> questionImg.setImageResource(R.drawable.zappa)
                7 -> questionImg.setImageResource(R.drawable.tony_iommi)
                8 -> questionImg.setImageResource(R.drawable.salvador_dali)
                9 -> questionImg.setImageResource(R.drawable.lemmy)
                10 -> questionImg.setImageResource(R.drawable.mason)
            }
        }
    }

    private fun defaultOptions() {
        val opt1 = findViewById<TextView>(R.id.quizAns1)
        val opt2 = findViewById<TextView>(R.id.quizAns2)
        val opt3 = findViewById<TextView>(R.id.quizAns3)
        val opt4 = findViewById<TextView>(R.id.quizAns4)
        val opt5 = findViewById<TextView>(R.id.quizAns5)

        val options = ArrayList<TextView>()
        options.add(0, opt1)
        options.add(1, opt2)
        options.add(2, opt3)
        options.add(3, opt4)
        options.add(4, opt5)

        for (option in options) {
            option.setTextColor(Color.parseColor("#000000"))
            option.setBackgroundColor(Color.parseColor("#808080"))
        }
    }
}