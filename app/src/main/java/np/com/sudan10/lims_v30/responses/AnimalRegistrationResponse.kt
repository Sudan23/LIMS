package np.com.sudan10.lims_v30.responses

import com.google.gson.annotations.SerializedName

data class AnimalRegistrationResponse (
        @SerializedName("SucessEntry")
        val successEntry: String,

)