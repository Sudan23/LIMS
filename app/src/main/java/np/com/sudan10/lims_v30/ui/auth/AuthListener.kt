package np.com.sudan10.lims_v30.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onStarted()

    fun onSuccess(loginResponse: LiveData<String>)

    fun onFailure(message: String)


}