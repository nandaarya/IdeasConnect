package com.example.ideasconnect.ui.signup

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.ideasconnect.R
import com.example.ideasconnect.ViewModelFactory
import com.example.ideasconnect.databinding.ActivitySignupBinding
import com.example.ideasconnect.ui.login.LoginActivity
import com.example.ideasconnect.data.Result

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var signupViewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
//        signupViewModel = ViewModelProvider(this, factory)[SignupViewModel::class.java]
//
//        signupViewModel.registerResponse.observe(this) {
//            when (it) {
//                is Result.Loading -> {
//                    showLoading(true)
//                }
//                is Result.Success -> {
//                    showLoading(false)
//                    AlertDialog.Builder(this).apply {
//                        setTitle("Yeah!")
//                        setMessage(getString(R.string.register_dialog_message))
//                        setCancelable(false)
//                        setPositiveButton(getString(R.string.dialog_positive_button)) { _, _ ->
//                            val intent = Intent(context, LoginActivity::class.java)
//                            startActivity(intent)
//                            finish()
//                        }
//                        create()
//                        show()
//                    }
//                }
//                is Result.Error -> {
//                    registerFailedToast()
//                    showLoading(false)
//                }
//            }
//        }

        setupView()
        setupAction()
        playAnimation()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.signupButton.setOnClickListener {
            binding.apply {
                if (nameEditText.error.isNullOrEmpty() && emailEditText.error.isNullOrEmpty() && edtPasswordSignup.error.isNullOrEmpty()) {
                    val name = nameEditText.text.toString().trim()
                    val email = emailEditText.text.toString().trim()
                    val password = edtPasswordSignup.text.toString().trim()
                    signupViewModel.register(name, email, password)
                } else {
                    registerFailedToast()
                }
            }
        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(100)
        val nameTextView =
            ObjectAnimator.ofFloat(binding.nameTextView, View.ALPHA, 1f).setDuration(100)
        val nameEditTextLayout =
            ObjectAnimator.ofFloat(binding.nameEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(100)
        val emailEditTextLayout =
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(100)
        val passwordEditTextLayout =
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(100)


        AnimatorSet().apply {
            playSequentially(
                title,
                nameTextView,
                nameEditTextLayout,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                signup
            )
            startDelay = 100
        }.start()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun registerFailedToast() {
        Toast.makeText(
            this,
            R.string.register_failed,
            Toast.LENGTH_SHORT
        ).show()
    }
}