package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class FarmRegistrationPost(
        @SerializedName("Category")
        val category: String?,
        @SerializedName("CitizenshipNo")
        val citizenshipNo: String?,
        @SerializedName("DistanceFromHighway")
        val distanceFromHighway: String?,
        @SerializedName("DistanceFromRoad")
        val distanceFromRoad: String?,
        @SerializedName("District")
        val district: String?,
        @SerializedName("DrinkingWaterFacility")
        val drinkingWaterFacility: Boolean?,
        @SerializedName("ElectricityFacility")
        val electricityFacility: Boolean?,
        @SerializedName("Email")
        val email: String?,
        @SerializedName("FarmType")
        val farmType: String?,
        @SerializedName("FarmerEthnicity")
        val farmerEthnicity: String?,
        @SerializedName("ForeignJobExperience")
        val foreignJobExperience: Boolean?,
        @SerializedName("HouseNear100M")
        val houseNear100M: String?,
        @SerializedName("HouseNear50M")
        val houseNear50M: String?,

        @SerializedName("Latitude")
        val latitude: String?,
        @SerializedName("LocalLevel")
        val localLevel: String?,
        @SerializedName("Longitude")
        val longitude: String?,
        @SerializedName("MunicipalityTaxIdentificationNumber")
        val municipalityTaxIdentificationNumber: String?,
        @SerializedName("NameEnglish")
        val nameEnglish: String?,
        @SerializedName("NameNepali")
        val nameNepali: String?,
        @SerializedName("NatureOfWork")
        val natureOfWork: String?,
        @SerializedName("PanNO")
        val panNO: String?,
        @SerializedName("Phone")
        val phone: String?,
        @SerializedName("Pprs")
        val pprs: Boolean?,
        @SerializedName("Province")
        val province: String?,
        @SerializedName("RegNo")
        val regNo: String?,
        @SerializedName("RegisteredDate")
        val registeredDate: String?,
        @SerializedName("RoadFacility")
        val roadFacility: Boolean?,
        @SerializedName("Tole")
        val tole: String?,
        @SerializedName("Url")
        val url: String?,
        @SerializedName("Ward")
        val ward: String?
)