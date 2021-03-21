package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.FeedbackPost
import np.com.sudan10.lims_v30.data.responses.FeedbackResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface FeedbackApi {

    @POST("/odata/Feedback")
    suspend fun feedbackSubmit(
        @Body post: FeedbackPost
    ): FeedbackResponse

}