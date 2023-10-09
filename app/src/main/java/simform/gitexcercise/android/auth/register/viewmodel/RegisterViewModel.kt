package simform.gitexcercise.android.auth.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import simform.gitexcercise.android.auth.register.model.RegisterCredential
import simform.gitexcercise.android.auth.register.model.RegistrationResponse
import simform.gitexcercise.android.auth.register.model.RegistrationResponse.*
import simform.gitexcercise.android.utils.isValidEmail
import simform.gitexcercise.android.utils.isValidPassword

class RegisterViewModel : ViewModel() {
    var registerCredential = MutableLiveData(RegisterCredential())

    fun validateRegistrationDetails(): RegistrationResponse =
        registerCredential.value?.run {
            if (name.isEmpty()) InvalidName
            if (!email.isValidEmail()) InvalidEmail
            if (!password.isValidPassword()) InvalidPassword
            if (password != confirmPassword) InvalidConfirmPassword
            RegistrationSuccessful
        } ?: InvalidName
}