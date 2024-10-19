package com.example.headhuntersamplelab1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

data class Job(
    val title: String,
    val companyName: String,
    val location: String,
    val experience: String,
    val publishedDate: String
)

class JobAdapter(private var jobList: List<Job>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTitle: TextView = itemView.findViewById(R.id.jobTitle)
        val companyName: TextView = itemView.findViewById(R.id.companyName)
        val jobLocation: TextView = itemView.findViewById(R.id.jobLocation)
        val jobExperience: TextView = itemView.findViewById(R.id.jobExperience)
        val publishedDate: TextView = itemView.findViewById(R.id.publishedDate)
        val applyButton: Button = itemView.findViewById(R.id.applyButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.job_item, parent, false)
        return JobViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        holder.jobTitle.text = job.title
        holder.companyName.text = job.companyName
        holder.jobLocation.text = job.location
        holder.jobExperience.text = job.experience
        holder.publishedDate.text = job.publishedDate

        // Переход на экран с деталями вакансии
        holder.applyButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, JobDetailsActivity::class.java)
            intent.putExtra("jobTitle", job.title)
            intent.putExtra("jobExperience", job.experience)
            intent.putExtra("companyName", job.companyName)
            intent.putExtra("jobDescription", "Подробное описание вакансии для ${job.title}")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    // Метод для обновления списка вакансий и перерисовки элементов
    fun updateJobs(newJobList: List<Job>) {
        jobList = newJobList
        notifyDataSetChanged() // Перерисовываем элементы
    }
}
