package np.com.sudan10.lims_v30.ui.feedback

interface FeedbackListener {

    fun onClicked()

    fun onSuccess()

    fun onFailure(message: String)
}