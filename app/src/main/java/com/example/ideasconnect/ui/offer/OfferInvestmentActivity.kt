package com.example.ideasconnect.ui.offer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ideasconnect.R
import com.example.ideasconnect.data.response.IdeaListItem
import com.example.ideasconnect.databinding.ActivityDetailBinding
import com.example.ideasconnect.databinding.ActivityOfferInvestmentBinding
import com.example.ideasconnect.ui.detail.DetailActivity
import com.example.ideasconnect.ui.main.MainActivity

class OfferInvestmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfferInvestmentBinding
    lateinit var data: IdeaListItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfferInvestmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Investasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(DetailActivity.EXTRA_IDEA_DETAIL, IdeaListItem::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(DetailActivity.EXTRA_IDEA_DETAIL)!!
        }

        binding.tvIdeaTitle.text = data.ideaTitle
        binding.tvDeveloperName.text = data.developerName

        binding.btnOfferInvestment.setOnClickListener {
            // submit data ke api
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_IDEA_DETAIL = "Idea Detail"
    }
}