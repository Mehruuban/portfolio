package com.mehru.myportfolio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddSkillActivity : AppCompatActivity() {


    private lateinit var editSkillName: EditText
    private lateinit var btnAddSkill: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_skill)

        editSkillName = findViewById(R.id.editSkillName)
        btnAddSkill = findViewById(R.id.btnAddSkill)

        btnAddSkill.setOnClickListener {
            val skill = editSkillName.text.toString().trim()

            if (skill.isEmpty()) {
                Toast.makeText(this, "Please enter a skill", Toast.LENGTH_SHORT).show()
            } else {
                val resultIntent = Intent()
                resultIntent.putExtra("newSkill", skill)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }

        }
    }
}