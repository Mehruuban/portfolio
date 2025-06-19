package com.example.portfolio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehru.myportfolio.AddSkillActivity
import com.mehru.myportfolio.SkillAdapter
import com.mehru.myportfolio.databinding.ActivitySkillBinding

class SkillsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkillBinding
    private val skillList = mutableListOf<String>()
    private lateinit var skillAdapter: SkillAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        skillAdapter = SkillAdapter(skillList)
        binding.recyclerViewSkills.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewSkills.adapter = skillAdapter

        binding.fabAddSkill.setOnClickListener {
            val intent = Intent(this, AddSkillActivity::class.java)
            startActivityForResult(intent, 1001)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1001 && resultCode == RESULT_OK) {
            val newSkill = data?.getStringExtra("newSkill")
            newSkill?.let {
                skillList.add(it)
                skillAdapter.notifyItemInserted(skillList.size - 1)
            }
        }
    }
}
