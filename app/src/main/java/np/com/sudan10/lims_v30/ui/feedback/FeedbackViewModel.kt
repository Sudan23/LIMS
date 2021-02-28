package np.com.sudan10.lims_v30.ui.feedback

import android.view.View
import androidx.lifecycle.ViewModel
import np.com.sudan10.lims_v21.repository.FeedbackRepository

class FeedbackViewModel(private val repository: FeedbackRepository) : ViewModel() {
    var fullName: String? = null
    var address:String? = null
    var feedbackEmail: String? = null
    var feedbackCategory: String? = null
        get() = feedbackCategory

    var feedbackMessage: String? = null
    var feedbackListener: FeedbackListener? = null

    fun onSendClick(view : View){
        feedbackListener?.onClicked()

        if (fullName.isNullOrEmpty() ||
                address.isNullOrEmpty() ||
                feedbackEmail.isNullOrEmpty() ||
                feedbackCategory.isNullOrEmpty()||
                feedbackMessage.isNullOrEmpty()) {

            feedbackListener?.onFailure("Please fill all the fields")

            return

        }
        feedbackListener?.onSuccess()

    }


}