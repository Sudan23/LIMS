package np.com.sudan10.lims_v21.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import np.com.sudan10.lims_v30.data.network.AuthApi
import np.com.sudan10.lims_v30.data.repository.BaseRepository
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository(
        private val api:AuthApi
) : BaseRepository() {

    suspend fun login (
            email: String,
            password: String
    ) = safeApiCall {
        api.login(email, password)
    }

}