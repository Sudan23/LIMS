package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class FarmFarmerRegistrationResponse(
    @SerializedName("Category")
    val category: String,
    @SerializedName("CitizenshipNo")
    val citizenshipNo: Any,
    @SerializedName("DistanceFromHighway")
    val distanceFromHighway: Any,
    @SerializedName("DistanceFromRoad")
    val distanceFromRoad: Any,
    @SerializedName("District")
    val district: Any,
    @SerializedName("DrinkingWaterFacility")
    val drinkingWaterFacility: Any,
    @SerializedName("ElectricityFacility")
    val electricityFacility: Any,
    @SerializedName("Email")
    val email: Any,
    @SerializedName("FarmType")
    val farmType: String,
    @SerializedName("FarmerEthnicity")
    val farmerEthnicity: Any,
    @SerializedName("ForeignJobExperience")
    val foreignJobExperience: Any,
    @SerializedName("HouseNear100M")
    val houseNear100M: Any,
    @SerializedName("HouseNear50M")
    val houseNear50M: Any,
    @SerializedName("Id")
    val id: String,
    @SerializedName("Latitude")
    val latitude: Any,
    @SerializedName("LocalLevel")
    val localLevel: Any,
    @SerializedName("Longitude")
    val longitude: Any,
    @SerializedName("MunicipalityTaxIdentificationNumber")
    val municipalityTaxIdentificationNumber: Any,
    @SerializedName("NameEnglish")
    val nameEnglish: String,
    @SerializedName("NameNepali")
    val nameNepali: String,
    @SerializedName("NatureOfWork")
    val natureOfWork: Any,
    @SerializedName("@odata.context")
    val odataContext: String,
    @SerializedName("PanNO")
    val panNO: Any,
    @SerializedName("Phone")
    val phone: Any,
    @SerializedName("Pprs")
    val pprs: Boolean,
    @SerializedName("Provience")
    val provience: Any,
    @SerializedName("RegNo")
    val regNo: Any,
    @SerializedName("RegisteredDate")
    val registeredDate: Any,
    @SerializedName("RoadFacility")
    val roadFacility: Any,
    @SerializedName("Tole")
    val tole: Any,
    @SerializedName("URL")
    val uRL: Any,
    @SerializedName("Ward")
    val ward: Any
)