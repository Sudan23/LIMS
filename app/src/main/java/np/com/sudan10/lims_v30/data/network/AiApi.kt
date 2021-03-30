package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.SubmitAidataclass
import retrofit2.http.Body
import retrofit2.http.POST

interface AiApi {

    @POST("/oda/ai")
    suspend fun SubmitAi(
            @Body post: SubmitAidataclass
    ): SubmitAidataclass

}
