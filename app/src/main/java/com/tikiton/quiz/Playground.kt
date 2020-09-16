package com.tikiton.quiz

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.graphics.Color
import android.content.Intent
import android.widget.TextView
import com.tikiton.quiz.data.QuestionDAO
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_playground.*

class Playground : AppCompatActivity() {
    private var choiceIndex: Int = 0
    private var waitingForNext = false
    private var failedQuestions: Int = 0
    private var passedQuestions: Int = 0
    private var backPressedTime: Long = 0
    private var currentQuestionIndex: Int = 0
    private val questions = QuestionDAO.getQuestions()
    private var currentQuestion = questions[currentQuestionIndex]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)

        val userName = intent.getStringExtra("userName")

        setQuestionOnUI()

        submitButton.setOnClickListener {
            // Check result & Highlight
            if(currentQuestion.answer != choiceIndex) {
                highlightError()
                failedQuestions += 1
            } else passedQuestions += 1
            highlightAnswer()
            // Hide submit button & show next button
            waitingForNext = true
            it.visibility = Button.INVISIBLE
            nextButton.visibility = Button.VISIBLE
        }

        nextButton.setOnClickListener {
            // End game or next question
            if((currentQuestionIndex + 1) == questions.size) {
                val resultBoardIntent = Intent(this, ResultBoard::class.java);
                resultBoardIntent.putExtra("userName", userName)
                resultBoardIntent.putExtra("failedQuestions", failedQuestions.toString())
                resultBoardIntent.putExtra("passedQuestions", passedQuestions.toString())
                startActivity(resultBoardIntent)
                finish()
            } else {
                currentQuestionIndex += 1
                currentQuestion = questions[currentQuestionIndex]
                setQuestionOnUI()
            }
            waitingForNext = false
            it.visibility = Button.INVISIBLE
            submitButton.visibility = Button.VISIBLE
        }
    }

    // Highlight selected choice
    fun onSelectChoice(view: View) {
        if(!waitingForNext) {
            val choiceView = (view as TextView)
            choiceIndex = currentQuestion.choices.indexOf(choiceView.text.toString())
            highlightChoice(choiceView)
        }
    }

    // Highlight correct answer
    private fun highlightAnswer() {
        when(currentQuestion.answer) {
            0 -> highlightCorrectChoice(choiceOne)
            1 -> highlightCorrectChoice(choiceTwo)
            2 -> highlightCorrectChoice(choiceTree)
            3 -> highlightCorrectChoice(choiceFour)
        }
    }

    // Highlight wrong answer
    private fun highlightError() {
        when(choiceIndex) {
            0 -> highlightWrongChoice(choiceOne)
            1 -> highlightWrongChoice(choiceTwo)
            2 -> highlightWrongChoice(choiceTree)
            3 -> highlightWrongChoice(choiceFour)
        }
    }

    // Highlight selected choice
    private fun highlightChoice(choiceTextView: TextView) {
        resetChoicesHighlight()
        choiceTextView.setTextColor(Color.WHITE)
        choiceTextView.setBackgroundColor(Color.GRAY)
    }

    // Highlight correct choice
    private fun highlightCorrectChoice(choiceTextView: TextView) {
        choiceTextView.setTextColor(Color.WHITE)
        choiceTextView.setBackgroundColor(Color.GREEN)
    }

    // Highlight wrong choice
    private fun highlightWrongChoice(choiceTextView: TextView) {
        choiceTextView.setTextColor(Color.WHITE)
        choiceTextView.setBackgroundColor(Color.RED)
    }

    // Off all choice
    private fun resetChoicesHighlight() {
        choiceOne.setTextColor(Color.BLACK)
        choiceOne.setBackgroundColor(Color.WHITE)
        choiceTwo.setTextColor(Color.BLACK)
        choiceTwo.setBackgroundColor(Color.WHITE)
        choiceTree.setTextColor(Color.BLACK)
        choiceTree.setBackgroundColor(Color.WHITE)
        choiceFour.setTextColor(Color.BLACK)
        choiceFour.setBackgroundColor(Color.WHITE)
    }

    // Update UI
    private fun setQuestionOnUI() {
        resetChoicesHighlight()
        val currentQuestion = currentQuestion
        choiceOne.text = currentQuestion.choices[0]
        choiceTwo.text = currentQuestion.choices[1]
        choiceTree.text = currentQuestion.choices[2]
        choiceFour.text = currentQuestion.choices[3]
        questionText.text = currentQuestion.question
        progressBar.progress = currentQuestionIndex + 1
        questionImage.setImageResource(currentQuestion.image)
        progressText.text = ("${currentQuestionIndex + 1}/${QuestionDAO.getQuestions().size}")
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
}