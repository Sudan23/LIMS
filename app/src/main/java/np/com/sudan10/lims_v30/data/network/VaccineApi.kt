package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.responses.*
import retrofit2.http.Body
import retrofit2.http.POST

interface VaccineApi {

    @POST("/Api/Token/Create")
    suspend fun postVaccine(
            @Body post: VaccinePost
    ) : VaccineResponse

}