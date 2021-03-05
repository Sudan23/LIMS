package np.com.sudan10.lims_v30.ui.auth

import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.responses.LoginResponse

interface AuthListener {

    fun onStarted()

    fun onSuccess(loginResponse: String)

    fun onFailure(message: String)


}