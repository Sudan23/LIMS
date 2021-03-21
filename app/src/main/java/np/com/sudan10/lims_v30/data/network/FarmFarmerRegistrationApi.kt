package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.FarmRegistrationPost
import np.com.sudan10.lims_v30.data.responses.FarrmFarmerRegistrationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface FarmFarmerRegistrationApi {

    @POST("/odata/Farm")
    suspend fun register(
            @Body post: FarmRegistrationPost
    ): FarrmFarmerRegistrationResponse
}