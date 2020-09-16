package com.tikiton.quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result_board.*

class ResultBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_board)

        val userName = intent.getStringExtra("userName")
        val failedQuestions = intent.getStringExtra("failedQuestions")
        val passedQuestions = intent.getStringExtra("passedQuestions")

        failed.text = failedQuestions
        passed.text = passedQuestions
        userNameDisplay.text = userName

        playAgain.setOnClickListener {
            val playgroundIntent = Intent(this, Playground::class.java);
            playgroundIntent.putExtra("userName", userName)
            startActivity(playgroundIntent)
            finish()
        }
    }
}