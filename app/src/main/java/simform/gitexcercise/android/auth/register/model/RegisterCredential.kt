package simform.gitexcercise.android.auth.register.model

data class RegisterCredential(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
)
