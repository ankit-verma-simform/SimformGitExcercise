package simform.gitexcercise.android.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import simform.gitexcercise.android.R
import simform.gitexcercise.android.auth.login.view.LoginFragment
import simform.gitexcercise.android.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        attachLoginScreenFragment()
    }

    private fun attachLoginScreenFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.auth_fragment_container, LoginFragment())
            .commit()
    }
}