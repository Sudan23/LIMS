package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.FarmRegistrationPost
import np.com.sudan10.lims_v30.data.responses.FarmFarmerRegistrationResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FarmFarmerRegistrationApi {

    @POST("/odata/Farm")
    suspend fun farmRegister(
            @Body post: FarmRegistrationPost
    ): FarmFarmerRegistrationResponse

    @GET("/odata/Farm")
    suspend fun farmList(
            @Body get: FarmRegistrationPost
    ): FarmFarmerRegistrationResponse
}