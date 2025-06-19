package com.mehru.myportfolio

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.portfolio.SkillsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val skills  = findViewById<TextView>(R.id.skills)
        val projects = findViewById<TextView>(R.id.projects)
        val certification = findViewById<TextView>(R.id.certification)
        val github = findViewById<TextView>(R.id.github)

        skills.setOnClickListener {
            val intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }

        projects.setOnClickListener {
            val intent = Intent(this, ProjectsActivity::class.java)
            startActivity(intent)
        }

        certification.setOnClickListener {
            val intent = Intent(this, CertificationsActivity::class.java)
            startActivity(intent)
        }

        github.setOnClickListener {
            val intent = Intent(this, webActivity::class.java)
            startActivity(intent)
        }



    }
}