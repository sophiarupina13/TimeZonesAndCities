package com.example.timezonesandcities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private var countdownTimer: CountDownTimer? = null
    private var secondsRemaining: Long = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        timerTextView = findViewById(R.id.timer)

        // Запускаем таймер
        startCountdownTimer()
    }

    private fun startCountdownTimer() {
        countdownTimer = object : CountDownTimer(secondsRemaining * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsRemaining = millisUntilFinished / 1000
                updateTimerTextView()
            }

            override fun onFinish() {
                // Таймер завершен, выполните необходимые действия
                timerTextView.text = "00:00"
                val intent = Intent(this@MainActivity4, MainActivity5::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }

    private fun updateTimerTextView() {
        val minutes = secondsRemaining / 60
        val seconds = secondsRemaining % 60
        timerTextView.text = String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Очищаем ресурсы при уничтожении активности
        countdownTimer?.cancel()
    }

}