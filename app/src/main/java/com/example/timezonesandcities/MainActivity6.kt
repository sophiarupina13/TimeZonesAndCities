package com.example.timezonesandcities

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {

    private lateinit var replayButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val pointsTextView = findViewById<TextView>(R.id.points)
        replayButton = findViewById(R.id.button_replay)

        // Get the points value from the intent
        val points = intent.getIntExtra("points", 0)

        // Set the points value to the TextView
        pointsTextView.text = "$points Points"

        // Постепенное появление кнопки replay после 2 секунд
        Handler().postDelayed({
            runOnUiThread {
                val fadeIn = ObjectAnimator.ofFloat(replayButton, "alpha", 0f, 1f)
                fadeIn.duration = 1000 // Длительность анимации в миллисекундах
                replayButton.visibility = View.VISIBLE
                fadeIn.start()
            }
        }, 2000)

        replayButton.setOnClickListener {
            val intent = Intent(this@MainActivity6, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

