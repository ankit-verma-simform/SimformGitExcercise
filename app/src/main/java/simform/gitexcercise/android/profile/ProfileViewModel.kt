package simform.gitexcercise.android.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var profileDetails = MutableLiveData(
        ProfileDetails(
            name = "Ankit Verma",
            email = "ankit@gmail.co",
            password = "ankit@12345"
        )
    )
}