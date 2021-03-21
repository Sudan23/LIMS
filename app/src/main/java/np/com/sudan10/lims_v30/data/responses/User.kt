package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)