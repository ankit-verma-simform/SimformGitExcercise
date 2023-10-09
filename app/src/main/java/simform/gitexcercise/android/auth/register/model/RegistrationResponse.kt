package simform.gitexcercise.android.auth.register.model

import androidx.annotation.StringRes
import simform.gitexcercise.android.R

sealed class RegistrationResponse(@StringRes val messageId: Int) {
    object RegistrationSuccessful : RegistrationResponse(R.string.msg_registration_successful)
    object InvalidEmail : RegistrationResponse(R.string.error_invalid_email)
    object InvalidName : RegistrationResponse(R.string.error_invalid_name)
    object InvalidPassword : RegistrationResponse(R.string.error_invalid_password)
    object InvalidConfirmPassword : RegistrationResponse(R.string.error_confirm_password_match)
}