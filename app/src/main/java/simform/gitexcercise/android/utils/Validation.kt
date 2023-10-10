package simform.gitexcercise.android.utils

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this.trim()).matches()
}

fun String.isValidPassword(): Boolean {
    return length > 8
}