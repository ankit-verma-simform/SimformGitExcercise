package simform.gitexcercise.android.auth.register.view

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
import simform.gitexcercise.android.auth.register.model.RegistrationResponse
import simform.gitexcercise.android.auth.register.viewmodel.RegisterViewModel
import simform.gitexcercise.android.databinding.FragmentRegisterBinding
import simform.gitexcercise.android.profile.ProfileActivity

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        binding.viewModel = viewModel

        binding.btnRegister.setOnClickListener {
            val registrationResponse = viewModel.validateRegistrationDetails()
            if (registrationResponse is RegistrationResponse.RegistrationSuccessful) {
                Toast.makeText(context, getString(registrationResponse.messageId), Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ProfileActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(context, getString(registrationResponse.messageId), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}