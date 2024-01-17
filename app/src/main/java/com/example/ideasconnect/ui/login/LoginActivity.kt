package com.example.ideasconnect.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ideasconnect.databinding.ActivityLoginBinding
import com.example.ideasconnect.ui.main.MainActivity
import com.example.ideasconnect.ui.signup.SignupActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
//        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
//
//        loginViewModel.getSession().observe(this) { user ->
//            if (user.isLogin) {
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }
//        }
//
//        loginViewModel.loginResponse.observe(this) {
//            when (it) {
//                is Result.Loading -> {
//                    showLoading(true)
//                }
//                is Result.Success -> {
//                    showLoading(false)
//                }
//                is Result.Error -> {
//                    AlertDialog.Builder(this).apply {
//                        setTitle(getString(R.string.login_failed_dialog_title))
//                        setMessage(getString(R.string.login_failed_dialog))
//                        create()
//                        show()
//                    }
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
        binding.loginButton.setOnClickListener {
//            binding.apply {
//                if (emailEditText.error.isNullOrEmpty() && edtPasswordLogin.error.isNullOrEmpty()) {
//                    val email = emailEditText.text.toString().trim()
//                    val password = edtPasswordLogin.text.toString().trim()
//                    loginViewModel.login(email, password)
//                }
//            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(100)
        val message =
            ObjectAnimator.ofFloat(binding.messageTextView, View.ALPHA, 1f).setDuration(100)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(100)
        val emailEditTextLayout =
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(100)
        val passwordEditTextLayout =
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val login = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(100)
        val signupTextView =
            ObjectAnimator.ofFloat(binding.tvSignup, View.ALPHA, 1f).setDuration(100)
        val signupButton =
            ObjectAnimator.ofFloat(binding.btnSignup, View.ALPHA, 1f).setDuration(100)

        AnimatorSet().apply {
            playSequentially(
                title,
                message,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                login,
                signupTextView,
                signupButton
            )
            startDelay = 100
        }.start()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}