package simform.gitexcercise.android.auth.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import simform.gitexcercise.android.R
import simform.gitexcercise.android.auth.register.viewmodel.RegisterViewModel
import simform.gitexcercise.android.databinding.FragmentRegisterBinding

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
            Toast.makeText(
                context,
                getString(viewModel.validateRegistrationDetails().messageId),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnLogin.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}