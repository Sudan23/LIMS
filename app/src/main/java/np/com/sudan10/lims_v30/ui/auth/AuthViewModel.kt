package np.com.sudan10.lims_v30.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel(){

    var email: String? = null
    var password: String? = null

    fun onLoginButtonClick(view: View){
        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
            //

            return
        }
        //Success

    }


}