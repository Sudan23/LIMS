package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.FarmFarmerRegistrationResponse
import np.com.sudan10.lims_v30.data.responses.FarmRegistrationPost
import retrofit2.http.Body
import retrofit2.http.POST

interface MilkRecordingApi {
    @POST("/odata/Farm")
    suspend fun farmRegister(
            @Body post: FarmRegistrationPost
    ): FarmFarmerRegistrationResponse

}
