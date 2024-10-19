package com.example.headhuntersamplelab1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var jobAdapter: JobAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var jobList: List<Job>  // List to store job objects

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Пример данных вакансий
        jobList = listOf(
            Job("Android Developer (Kotlin)", "АО «ОТП Банк»", "Москва", "Опыт от 3 до 6 лет", "Опубликовано 3 октября"),
            Job("Android Developer (Middle/Senior)", "RedLab", "Тбилиси", "Опыт от 3 до 6 лет", "Опубликовано 3 октября"),
            Job("Android Developer (Junior)", "StartTech", "Санкт-Петербург", "Опыт от 1 до 3 лет", "Опубликовано 7 октября")
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        jobAdapter = JobAdapter(jobList)
        recyclerView.adapter = jobAdapter

        // Поиск
        val searchBar = findViewById<EditText>(R.id.searchBar)
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterJobs(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // Фильтрация вакансий по запросу
    private fun filterJobs(query: String?) {
        val filteredList = jobList.filter { job ->
            job.title.contains(query ?: "", ignoreCase = true)
        }
        jobAdapter.updateJobs(filteredList)
    }
}
