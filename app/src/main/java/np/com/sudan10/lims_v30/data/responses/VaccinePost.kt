package np.com.sudan10.lims_v30.data.responses

import com.google.gson.annotations.SerializedName

data class VaccinePost (
        @SerializedName("FramFarmerName")
        val farmFarmerName: String,
        @SerializedName("EarTagNo")
        val earTagNo: String,
        @SerializedName("AnimalName")
        val animalName: String,
        @SerializedName("MobileNo")
        val mobileNo: String,
        @SerializedName("Species")
        val species: String,
        @SerializedName("Breed")
        val breed: String,
        @SerializedName("VaccineName")
        val vaccineName: String,
        @SerializedName("VaccineDate")
        val vaccineDate: String,
        @SerializedName("VaccinationFor")
        val vaccinationForDisease: String?,
        @SerializedName("FiscalYear")
        val fiscalYear: String,
        @SerializedName("TechnicianName")
        val technicianName: String
)