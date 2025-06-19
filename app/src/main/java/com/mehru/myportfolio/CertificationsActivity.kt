package com.mehru.myportfolio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CertificationsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private val certificationList = mutableListOf<CertificationModel>()
    private lateinit var certificationAdapter: CertificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certifications)

        recyclerView = findViewById(R.id.recyclerViewCertifications)
        fab = findViewById(R.id.fabAddCertification)

        certificationAdapter = CertificationAdapter(certificationList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = certificationAdapter

        fab.setOnClickListener {
            val intent = Intent(this, AddCertificationActivity::class.java)
            startActivityForResult(intent, 3001)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 3001 && resultCode == Activity.RESULT_OK) {
            val title = data?.getStringExtra("certificationTitle")
            val issuer = data?.getStringExtra("certificationIssuer")

            if (!title.isNullOrEmpty() && !issuer.isNullOrEmpty()) {
                certificationList.add(CertificationModel(title, issuer))
                certificationAdapter.notifyItemInserted(certificationList.size - 1)
            } else {
                Toast.makeText(this, "Missing certification data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
