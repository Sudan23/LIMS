package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.ui.auth.LoginPost
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("/Api/Token/Create")
    suspend fun pushLoginPost(
        @Body post: LoginPost
    ): Response<LoginPost>
}