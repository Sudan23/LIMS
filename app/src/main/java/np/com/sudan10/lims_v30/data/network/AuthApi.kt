package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("/Api/Token/Create")
    suspend fun login(
            @Field("email") email: String,
            @Field("password") password: String
    ) : LoginResponse

}