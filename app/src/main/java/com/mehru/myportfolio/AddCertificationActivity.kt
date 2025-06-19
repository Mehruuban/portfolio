package com.mehru.myportfolio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddCertificationActivity : AppCompatActivity() {

    private lateinit var editTitle: EditText
    private lateinit var editIssuer: EditText
    private lateinit var btnAddCertification: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_certification)

        editTitle = findViewById(R.id.editCertificationTitle)
        editIssuer = findViewById(R.id.editCertificationIssuer)
        btnAddCertification = findViewById(R.id.btnSubmitCertification)

        btnAddCertification.setOnClickListener {
            val title = editTitle.text.toString().trim()
            val issuer = editIssuer.text.toString().trim()

            if (title.isEmpty() || issuer.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("certificationTitle", title)
                intent.putExtra("certificationIssuer", issuer)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
