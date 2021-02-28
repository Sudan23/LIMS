package np.com.sudan10.lims_v30.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v21.repository.LoginRepository
import retrofit2.Response

class LoginViewModel(private val repository: LoginRepository): ViewModel() {
    val myLoginResponse:MutableLiveData<Response<LoginPost>> = MutableLiveData()

    fun pushLoginPost(post: LoginPost) {
        viewModelScope.launch {
            val response : Response<LoginPost> = repository.pushLoginPost(post)
            myLoginResponse.value = response
        }
    }

}