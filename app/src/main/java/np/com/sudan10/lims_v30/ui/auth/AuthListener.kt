package np.com.sudan10.lims_v30.ui.auth

import np.com.sudan10.lims_v30.responses.LoginResponse

interface AuthListener {

    fun onStarted()

    fun onSuccess(loginResponse: LoginResponse)

    fun onFailure(loginResponse: LoginResponse)


}