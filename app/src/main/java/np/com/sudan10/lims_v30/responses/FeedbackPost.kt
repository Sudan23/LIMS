package np.com.sudan10.lims_v30.responses


import com.google.gson.annotations.SerializedName

data class FeedbackPost(

    @SerializedName("FullName")
    val fullName: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("Address")
    val address: String,
    @SerializedName("Category")
    val category: String,
    @SerializedName("Message")
    val message: String
)