package np.com.sudan10.lims_v30.ui.auth

import android.util.Base64
import android.view.View
import androidx.lifecycle.ViewModel
import np.com.sudan10.lims_v21.repository.AuthRepository

class AuthViewModel(
        private val repository: AuthRepository
) : ViewModel(){

    var email: String? = null
    var password: String? = null
    var authListener : AuthListener? = null


    suspend fun onLoginButtonClick(view: View){
        authListener?.onStarted()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {

            authListener?.onFailure("Invalid Email or password")
            return
        }
        val byteA = password?.toByteArray()
        val encodedPassword = Base64.encodeToString(byteA, Base64.DEFAULT)

        // Dependency injection needed
        authListener?.onSuccess("Login Response Success")

    }


}