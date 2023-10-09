package simform.gitexcercise.android.auth.login.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import simform.gitexcercise.android.R
import simform.gitexcercise.android.auth.forgotpassword.ForgotPasswordFragment
import simform.gitexcercise.android.auth.login.viewmodel.LoginViewModel
import simform.gitexcercise.android.auth.register.view.RegisterFragment
import simform.gitexcercise.android.databinding.FragmentLoginBinding
import simform.gitexcercise.android.profile.ProfileActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewModel = viewModel

        binding.btnLogin.setOnClickListener {
            if (viewModel.isValidLogin) {
                Toast.makeText(context, getString(R.string.msg_login_success), Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ProfileActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(context, getString(R.string.msg_login_failed), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.auth_fragment_container, RegisterFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnForgotPassword.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.auth_fragment_container, ForgotPasswordFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}