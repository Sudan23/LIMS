package np.com.sudan10.lims_v30.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v21.repository.AuthRepository
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.responses.LoginResponse

class AuthViewModel(
        private val repository: AuthRepository
) : ViewModel(){

    var email: String? = null
    var password: String? = null
    var authListener : AuthListener? = null

    private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse : LiveData<Resource<LoginResponse>>
    get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }


}