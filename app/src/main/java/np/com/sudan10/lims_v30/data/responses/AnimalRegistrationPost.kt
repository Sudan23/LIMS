package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class AnimalRegistrationPost(
    @SerializedName("age")
    val age: Int,
    @SerializedName("animalColor")
    val animalColor: String,
    @SerializedName("breedId")
    val breedId: String,
    @SerializedName("damId")
    val damId: String,
    @SerializedName("dob")
    val dob: String,
    @SerializedName("earTagNo")
    val earTagNo: String,
    @SerializedName("entryType")
    val entryType: String,
    @SerializedName("farmId")
    val farmId: String,
    @SerializedName("gender")
    val gender: String,

    @SerializedName("milkStatus")
    val milkStatus: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("noOFCalving")
    val noOFCalving: String,
    @SerializedName("physicalDefact")
    val physicalDefact: String,
    @SerializedName("pregencyStatus")
    val pregencyStatus: String,
    @SerializedName("sireId")
    val sireId: String,
    @SerializedName("speciesId")
    val speciesId: String,
    @SerializedName("weight")
    val weight: Int
)