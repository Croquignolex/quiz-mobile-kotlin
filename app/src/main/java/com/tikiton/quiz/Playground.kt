package com.tikiton.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Playground : AppCompatActivity() {
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)
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