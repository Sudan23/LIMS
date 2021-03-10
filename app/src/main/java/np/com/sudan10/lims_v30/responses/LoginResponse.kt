package np.com.sudan10.lims_v30.responses


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status_code")
    var statusCode: Int,

    @SerializedName("token")
    val token: String,
)