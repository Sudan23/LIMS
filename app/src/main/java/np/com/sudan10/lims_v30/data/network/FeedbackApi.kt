package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.ui.feedback.FeedbackPost
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedbackApi {

    @GET("/odata/Feedback")
    suspend fun getPost(): Response<FeedbackPost>

    @POST("/odata/Feedback")
    suspend fun pushPost(
        @Body post: FeedbackPost
    ):Response<FeedbackPost>

}