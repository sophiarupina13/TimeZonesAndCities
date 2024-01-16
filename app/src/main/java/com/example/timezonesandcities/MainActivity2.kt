package com.example.timezonesandcities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val casualButton: Button = findViewById(R.id.button_casual)

        casualButton.setOnClickListener(View.OnClickListener {
            // Создаем интент для запуска SecondActivity
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            startActivity(intent)
            finish()
        })

        val fastButton: Button = findViewById(R.id.button_fast)

        fastButton.setOnClickListener(View.OnClickListener {
            // Создаем интент для запуска SecondActivity
            val intent = Intent(this@MainActivity2, MainActivity4::class.java)
            startActivity(intent)
            finish()
        })
    }
}