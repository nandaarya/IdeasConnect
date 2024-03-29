package com.example.ideasconnect.ui.submit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ideasconnect.R

class SubmitIdeaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_idea)

        supportActionBar?.title = "Submit Ide"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}