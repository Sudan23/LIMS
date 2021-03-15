package np.com.sudan10.lims_v30.responses


import com.google.gson.annotations.SerializedName

data class FeedbackResponse(
    @SerializedName("Address")
    val address: String,
    @SerializedName("Category")
    val category: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("FullName")
    val fullName: String,
    @SerializedName("Id")
    val id: String,
    @SerializedName("Message")
    val message: String,
    @SerializedName("@odata.context")
    val odataContext: String
)