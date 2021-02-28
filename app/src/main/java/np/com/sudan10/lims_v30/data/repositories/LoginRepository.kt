package np.com.sudan10.lims_v21.repository

import np.com.sudan10.lims_v30.data.repositories.RetrofitInstance
import np.com.sudan10.lims_v30.ui.auth.LoginPost
import retrofit2.Response

class LoginRepository {
    suspend fun pushLoginPost(post: LoginPost): Response<LoginPost> {
        return RetrofitInstance.loginApi.pushLoginPost(post)
    }
}