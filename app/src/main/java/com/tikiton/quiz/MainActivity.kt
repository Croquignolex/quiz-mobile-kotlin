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
            val nameFieldValue = nameField.text.toString()
            if(nameFieldValue.length > 2) {
                val playgroundIntent = Intent(baseContext, Playground::class.java);
                startActivity(playgroundIntent)
                finish()
            } else Toast.makeText(this, "Votre nom doit avoir au moins 2 caratères", Toast.LENGTH_LONG).show()
        }
    }
}