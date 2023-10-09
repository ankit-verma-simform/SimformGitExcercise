package simform.gitexcercise.android.auth.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.FragmentForgotPasswordBinding
import simform.gitexcercise.android.utils.isValidEmail

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_forgot_password, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnForgotPassword.setOnClickListener {
            val email = binding.textFieldEmail.editText?.text.toString()

            if (email.isValidEmail()) {
                Toast.makeText(
                    context,
                    getString(R.string.msg_check_email_to_reset_password),
                    Toast.LENGTH_SHORT
                ).show()
                parentFragmentManager.popBackStack()

            } else {
                Toast.makeText(
                    context,
                    getString(R.string.error_invalid_email),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}