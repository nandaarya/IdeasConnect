package com.example.ideasconnect.ui.detail

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ideasconnect.R
import com.example.ideasconnect.data.response.IdeaListItem
import com.example.ideasconnect.databinding.ActivityDetailBinding
import com.example.ideasconnect.ui.main.MainActivity
import com.example.ideasconnect.ui.offer.OfferInvestmentActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    lateinit var data: IdeaListItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail Ide"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_IDEA_DETAIL, IdeaListItem::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_IDEA_DETAIL)!!
        }

        binding.tvIdeaTitle.text = data.ideaTitle
        binding.tvIdeaDescription.text = data.ideaDescription
        binding.tvAdditionalDetail.text = data.additionalDetails
        binding.tvDeveloperName.text = data.developerName
        binding.tvSubmitDate.text = data.submissionDate

        binding.btnOfferInvestment.setOnClickListener {
            val intent = Intent(this, OfferInvestmentActivity::class.java)
            intent.putExtra(OfferInvestmentActivity.EXTRA_IDEA_DETAIL, data)
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