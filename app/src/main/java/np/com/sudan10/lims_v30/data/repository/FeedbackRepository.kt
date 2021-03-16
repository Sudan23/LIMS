package np.com.sudan10.lims_v21.repository

import np.com.sudan10.lims_v30.data.network.FeedbackApi
import np.com.sudan10.lims_v30.data.repository.BaseRepository
import np.com.sudan10.lims_v30.responses.FeedbackPost

class FeedbackRepository (
        private val api:FeedbackApi
        ) :BaseRepository(){

            suspend fun feedback (
                    fullName: String,
                    address:String,
                    feedbackEmail: String,
                    feedbackCategory: String?,
                    feedbackMessage: String

            ) = safeApiCall {
                api.feedbackSubmit(FeedbackPost(fullName,feedbackEmail,address,feedbackCategory,feedbackMessage))
            }

}
