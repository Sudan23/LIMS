package np.com.sudan10.lims_v30.ui.feedback

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v21.repository.FeedbackRepository
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.responses.FeedbackResponse


class FeedbackViewModel(private val repository: FeedbackRepository) : ViewModel() {
    var fullName: String? = null
    var address:String? = null
    var feedbackEmail: String? = null

    var feedbackMessage: String? = null

    private val _feedbackResponse : MutableLiveData<Resource<FeedbackResponse>> = MutableLiveData()
    val feedbackResponse : LiveData<Resource<FeedbackResponse>>
        get() = _feedbackResponse

    val feedbackCategory = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }



    fun sendFeedback(
            fullName: String,
            address: String,
            feedbackEmail: String,
            feedbackCategory: String?,
            feedbackMessage: String

    ) = viewModelScope.launch {
        _feedbackResponse.value = repository.feedback(fullName,address,feedbackEmail,feedbackCategory,feedbackMessage)
    }

}