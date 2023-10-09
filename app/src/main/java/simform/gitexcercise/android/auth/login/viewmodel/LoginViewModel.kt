package simform.gitexcercise.android.auth.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import simform.gitexcercise.android.auth.login.model.LoginCredential
import simform.gitexcercise.android.utils.isValidEmail
import simform.gitexcercise.android.utils.isValidPassword

class LoginViewModel() : ViewModel() {
    var loginCredential = MutableLiveData(LoginCredential())

    val isValidLogin: Boolean
        get() = loginCredential.value?.run {
            email.isValidEmail() && password.isValidPassword()
        } ?: false
}
