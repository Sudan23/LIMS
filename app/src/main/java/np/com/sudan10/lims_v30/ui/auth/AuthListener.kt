package np.com.sudan10.lims_v30.ui.auth

interface AuthListener {

    fun onStarted()

    fun onSuccess()

    fun onFailure(message: String)


}