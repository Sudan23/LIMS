package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class FarmRegistrationPost(
    @SerializedName("category")
    val category: String,
    @SerializedName("citizenshipNo")
    val citizenshipNo: String,
    @SerializedName("distanceFromHighway")
    val distanceFromHighway: String,
    @SerializedName("distanceFromRoad")
    val distanceFromRoad: String,
    @SerializedName("district")
    val district: String,
    @SerializedName("drinkingWaterFacility")
    val drinkingWaterFacility: Boolean,
    @SerializedName("electricityFacility")
    val electricityFacility: Boolean,
    @SerializedName("email")
    val email: String,
    @SerializedName("farmType")
    val farmType: String,
    @SerializedName("farmerEthnicity")
    val farmerEthnicity: String,
    @SerializedName("foreignJobExperience")
    val foreignJobExperience: Boolean,
    @SerializedName("houseNear100M")
    val houseNear100M: String,
    @SerializedName("houseNear50M")
    val houseNear50M: String,

    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("localLevel")
    val localLevel: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("municipalityTaxIdentificationNumber")
    val municipalityTaxIdentificationNumber: String,
    @SerializedName("nameEnglish")
    val nameEnglish: String,
    @SerializedName("nameNepali")
    val nameNepali: String,
    @SerializedName("natureOfWork")
    val natureOfWork: String,
    @SerializedName("panNO")
    val panNO: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("pprs")
    val pprs: Boolean,
    @SerializedName("province")
    val province: String,
    @SerializedName("regNo")
    val regNo: String,
    @SerializedName("registeredDate")
    val registeredDate: String,
    @SerializedName("roadFacility")
    val roadFacility: Boolean,
    @SerializedName("tole")
    val tole: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("ward")
    val ward: String
)