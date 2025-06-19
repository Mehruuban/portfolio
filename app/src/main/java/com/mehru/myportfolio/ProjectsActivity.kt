package com.mehru.myportfolio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolio.AddProjectActivity
import com.example.portfolio.ProjectAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProjectsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private val projectList = mutableListOf<ProjectModel>()
    private lateinit var projectAdapter: ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        recyclerView = findViewById(R.id.recyclerViewProjects)
        fab = findViewById(R.id.fabAddProject)

        projectAdapter = ProjectAdapter(projectList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = projectAdapter

        fab.setOnClickListener {
            val intent = Intent(this, AddProjectActivity::class.java)
            startActivityForResult(intent, 2001)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 2001 && resultCode == Activity.RESULT_OK) {
            val title = data?.getStringExtra("projectTitle")
            val desc = data?.getStringExtra("projectDescription")

            if (!title.isNullOrEmpty() && !desc.isNullOrEmpty()) {
                val project = ProjectModel(title, desc)
                projectList.add(project)
                projectAdapter.notifyItemInserted(projectList.size - 1)
            } else {
                Toast.makeText(this, "Project data is missing", Toast.LENGTH_SHORT).show()
            }
        }
    }
}