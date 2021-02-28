package np.com.sudan10.lims_v30.ui.auth


import com.google.gson.annotations.SerializedName

data class LoginPost(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)