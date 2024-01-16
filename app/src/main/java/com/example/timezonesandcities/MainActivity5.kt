package com.example.timezonesandcities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity5 : AppCompatActivity() {

    private val times: Map<Int, String> = hashMapOf(
        R.drawable.time1 to "Tokio",
        R.drawable.time2 to "Los Angeles",
        R.drawable.time3 to "Moscow",
        R.drawable.time4 to "New York",
        R.drawable.time5 to "Hong Kong",
        R.drawable.time6 to "London"
    )

    private val shownTimes = mutableListOf<Int>()

    private lateinit var time: ImageView
    private lateinit var answer: EditText
    private var points = 0
    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        time = findViewById<ImageView>(R.id.time)
        answer = findViewById<EditText>(R.id.answer)

        showRandomImage()

        val buttonOk = findViewById<Button>(R.id.button_ok)
        buttonOk.setOnClickListener {
            checkAnswer()
            showRandomImage()
        }

    }

    private fun showRandomImage() {
        // Проверяем, есть ли еще непоказанные изображения
        if (shownTimes.size < times.size) {
            // Получаем случайное непоказанное изображение
            val remainingImages = times.keys.toList() - shownTimes
            val randomIndex = random.nextInt(remainingImages.size)
            val randomImage = remainingImages[randomIndex]

            // Добавляем изображение в список показанных
            shownTimes.add(randomImage)

            // Устанавливаем случайное изображение
            time.setImageResource(randomImage)
            time.tag = randomImage to times[randomImage] // устанавливаем пару ключ-значение с временем и городом

            // Очищаем текст в EditText
            answer.text.clear()
        } else {
            // сбросить список показанных изображений
            shownTimes.clear()
            val intent = Intent(this@MainActivity5, MainActivity6::class.java)
            intent.putExtra("points", points)
            startActivity(intent)
            finish()
        }
    }

    private fun getCurrentImagePair(): Pair<Int, String>? {
        val tag = time.tag
        if (tag is Pair<*, *>) {
            val drawable = tag.first as? Int
            val answer = tag.second as? String
            if (drawable != null && answer != null) {
                return Pair(drawable, answer)
            }
        }
        return null
    }


    private fun checkAnswer() {
        val currentImagePair = getCurrentImagePair()

        // Проверка, что текущая пара не null
        if (currentImagePair != null) {
            val (_, correctAnswer) = currentImagePair
            val userAnswer = answer.text.toString()

            // Сравниваем ответ пользователя с правильным ответом
            if (userAnswer.equals(correctAnswer, ignoreCase = true)) {
                // Ответ верный, увеличиваем счетчик
                points++
            }
        }
    }

}