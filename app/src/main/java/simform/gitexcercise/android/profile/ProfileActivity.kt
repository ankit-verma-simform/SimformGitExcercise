package simform.gitexcercise.android.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        attachViewProfileScreenFragment()
    }

    private fun attachViewProfileScreenFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.profile_fragment_container, ViewProfileFragment())
            .commit()
    }
}