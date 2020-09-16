package com.tikiton.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton.setOnClickListener {
            val userName = nameField.text.toString()
            if(userName.length >= 2) {
                val playgroundIntent = Intent(this, Playground::class.java);
                playgroundIntent.putExtra("userName", userName)
                startActivity(playgroundIntent)
                finish()
            } else Toast.makeText(this, "Votre nom doit avoir au moins 2 caratères", Toast.LENGTH_LONG).show()
        }
    }
}