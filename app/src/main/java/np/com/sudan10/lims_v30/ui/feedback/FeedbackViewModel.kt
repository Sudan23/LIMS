package np.com.sudan10.lims_v30.ui.feedback

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v21.repository.FeedbackRepository
import retrofit2.Response

class FeedbackViewModel(private val repository: FeedbackRepository) : ViewModel() {
    var fullName: String? = null
    var address:String? = null
    var feedbackEmail: String? = null
    var feedbackCategory: String? = null

    var feedbackMessage: String? = null
    var feedbackListener: FeedbackListener? = null
    val myResponse: MutableLiveData<Response<FeedbackPost>> = MutableLiveData()

    /*fun pushPost(post: FeedbackPost) {
        viewModelScope.launch {
            val response :Response<FeedbackPost> = repository.pushPost(post)
            myResponse.value = response
        }

    }

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response

        }
    }*/

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
        val repository = FeedbackRepository()
        val viewModelFactory = FeedbackViewModelFactory(repository)

        /*private lateinit var viewModel: FeedbackViewModel
        viewModel = ViewModelProvider(this, viewModelFactory).get(FeedbackViewModel::class.java)*/

        val myPost = FeedbackPost(address!!,
                feedbackCategory!!,
                feedbackEmail!!,
                fullName!!,feedbackMessage!!)




    }


}