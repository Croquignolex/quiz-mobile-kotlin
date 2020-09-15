package com.tikiton.quiz

import android.os.Bundle
import android.widget.Toast
import com.tikiton.quiz.data.QuestionDAO
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_playground.*

class Playground : AppCompatActivity() {
    private var backPressedTime: Long = 0
    private var currentQuestionIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)

        setQuestionOnUI()
    }

    // Handle back button pressed
    override fun onBackPressed() {
        if((backPressedTime + 2000) > System.currentTimeMillis()) {
            // Can exit if there is 2 seconds between the back button double tap
            super.onBackPressed()
        } else {
            // Neither toast call to action message
            Toast.makeText(
                applicationContext,
                "Appuiyez à nouveau pour quitter",
                Toast.LENGTH_SHORT
            ).show()
        }
        // Update user back pressed time
        backPressedTime = System.currentTimeMillis()
    }

    private fun setQuestionOnUI() {
        val currentQuestion = QuestionDAO.getQuestions()[currentQuestionIndex]
        questionText.text = currentQuestion.question
        choiceOne.text = currentQuestion.choices[0]
        choiceTwo.text = currentQuestion.choices[1]
        choiceTree.text = currentQuestion.choices[2]
        choiceFour.text = currentQuestion.choices[3]
        questionImage.setImageResource(currentQuestion.image)
        progressText.text = ("${currentQuestionIndex}/${QuestionDAO.getQuestions().size}")
    }
}