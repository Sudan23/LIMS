package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.AnimalRegistrationPost
import np.com.sudan10.lims_v30.data.responses.AnimalRegistrationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AnimalRegistrationApi {

    @POST("/odata/AnimalRegistration")
    suspend fun animalRegister(
            @Body post: AnimalRegistrationPost
    ): AnimalRegistrationResponse
}