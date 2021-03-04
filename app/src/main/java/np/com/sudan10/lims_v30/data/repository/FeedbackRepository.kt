package np.com.sudan10.lims_v21.repository

import np.com.sudan10.lims_v30.data.repository.RetrofitInstance
import np.com.sudan10.lims_v30.ui.feedback.FeedbackPost
import retrofit2.Response

class FeedbackRepository {

    suspend fun getPost(): Response<FeedbackPost> {
       return RetrofitInstance.feedbackApi.getPost()
    }
    suspend fun pushPost(post: FeedbackPost): Response<FeedbackPost> {
        return RetrofitInstance.feedbackApi.pushPost(post)
    }

}