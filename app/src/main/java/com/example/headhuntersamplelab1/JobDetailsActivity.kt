package com.example.headhuntersamplelab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class JobDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_details)

        // Устанавливаем значения для элементов интерфейса
        val jobTitle = findViewById<TextView>(R.id.jobTitle)
        val jobExperience = findViewById<TextView>(R.id.jobExperience)
        val companyName = findViewById<TextView>(R.id.companyName)
        val jobDescription = findViewById<TextView>(R.id.jobDescription)

        // Получение данных из Intent
        jobTitle.text = intent.getStringExtra("jobTitle")
        jobExperience.text = intent.getStringExtra("jobExperience")
        companyName.text = intent.getStringExtra("companyName")
        jobDescription.text = intent.getStringExtra("jobDescription")

        // Установка действий для кнопки отклика
        val applyButton = findViewById<Button>(R.id.applyButton)
        applyButton.setOnClickListener {
            // Логика для отклика на вакансию
        }
    }
}
