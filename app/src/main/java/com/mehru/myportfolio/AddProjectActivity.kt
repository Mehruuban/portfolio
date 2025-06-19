package com.example.portfolio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.mehru.myportfolio.R

class AddProjectActivity : AppCompatActivity() {

    private lateinit var editTitle: EditText
    private lateinit var editDescription: EditText
    private lateinit var btnAddProject: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_project)

        editTitle = findViewById(R.id.editProjectTitle)
        editDescription = findViewById(R.id.editProjectDescription)
        btnAddProject = findViewById(R.id.btnSubmitProject)

        btnAddProject.setOnClickListener {
            val title = editTitle.text.toString().trim()
            val desc = editDescription.text.toString().trim()

            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("projectTitle", title)
                intent.putExtra("projectDescription", desc)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
