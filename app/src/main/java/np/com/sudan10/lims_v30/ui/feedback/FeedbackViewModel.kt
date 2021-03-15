package np.com.sudan10.lims_v30.ui.feedback

import android.view.View
import android.widget.AdapterView
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v21.repository.FeedbackRepository
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.responses.FeedbackPost
import np.com.sudan10.lims_v30.responses.FeedbackResponse
import np.com.sudan10.lims_v30.responses.LoginResponse


class FeedbackViewModel(private val repository: FeedbackRepository) : ViewModel() {
    var fullName: String? = null
    var address:String? = null
    var feedbackEmail: String? = null
    var feedbackCategory: String? = null

    var feedbackMessage: String? = null

    private val _feedbackResponse : MutableLiveData<Resource<FeedbackResponse>> = MutableLiveData()
    val feedbackResponse : LiveData<Resource<FeedbackResponse>>
        get() = _feedbackResponse



    val clicksListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            feedbackCategory = parent?.getItemAtPosition(position) as String
        }
    }


    fun sendFeedback(
            fullName: String,
            address: String,
            feedbackEmail: String,
            feedbackCategory: String,
            feedbackMessage: String

    ) = viewModelScope.launch {
        _feedbackResponse.value = repository.feedback(fullName,address,feedbackEmail,feedbackCategory,feedbackMessage)
    }

}