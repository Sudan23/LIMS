package np.com.sudan10.lims_v30.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel(){

    var email: String? = null
    var password: String? = null
    var authListener : AuthListener? = null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {

            authListener?.onFailure("Invalid Email or password")
            return
        }
        authListener?.onSuccess()

    }


}