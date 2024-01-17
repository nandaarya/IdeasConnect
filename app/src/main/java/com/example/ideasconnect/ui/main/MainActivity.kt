package com.example.ideasconnect.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ideasconnect.R
import com.example.ideasconnect.ViewModelFactory
import com.example.ideasconnect.databinding.ActivityMainBinding
import com.example.ideasconnect.data.Result
import com.example.ideasconnect.ui.profile.ProfileActivity
import com.example.ideasconnect.ui.submit.SubmitIdeaActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var rvIdeaListAdapter: IdeaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        rvIdeaListAdapter = IdeaListAdapter()

        binding.rvIdeaList.layoutManager = LinearLayoutManager(this)
        binding.rvIdeaList.adapter = rvIdeaListAdapter

        mainViewModel.getIdeaList()

        mainViewModel.ideaList.observe(this) {
            Log.d("list", it.toString())
            when (it) {
                is Result.Loading -> showLoading(true)
                is Result.Error -> {
                    showLoading(true)
                }
                is Result.Success -> {
                    if (it.data.isNotEmpty()) {
                        showLoading(false)
                        rvIdeaListAdapter.addIdeaList(it.data)
                    }
                }
            }
        }

        setOptionMenu()
        setFAB()
    }

    private fun setOptionMenu() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }

    private fun setFAB() {
        binding.fabSubmitIdea.setOnClickListener {
            val intent = Intent(this, SubmitIdeaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}