package np.com.sudan10.lims_v30.ui.feedback


import com.google.gson.annotations.SerializedName

data class FeedbackPost(
    @SerializedName("Address")
    val address: String,
    @SerializedName("Category")
    val category: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("FullName")
    val fullName: String,
        @SerializedName("Message")
    val message: String
)