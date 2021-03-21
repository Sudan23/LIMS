package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.responses.LoginResponse
import np.com.sudan10.lims_v30.responses.User
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("Api/Token/Create")
    suspend fun login(
            @Body post: User
    ) : LoginResponse

}