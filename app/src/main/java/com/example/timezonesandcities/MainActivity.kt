package com.example.timezonesandcities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: Button = findViewById(R.id.button_play)

        playButton.setOnClickListener(View.OnClickListener {
            // Создаем интент для запуска SecondActivity
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
            finish()
        })
    }
}