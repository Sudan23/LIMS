package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.VaccineApi
import np.com.sudan10.lims_v30.responses.FeedbackPost
import np.com.sudan10.lims_v30.responses.VaccinePost

class VaccinationRepository(
    private val api:VaccineApi
) : BaseRepository(){

    suspend fun submitVaccine (
        farmFarmerName:String,
        earTagNo:String,
        animalName:String,
        mobileNo:String,
        species:String,
        breed:String,
        vaccineName:String,
        vaccineDate:String,
        vaccineforDiseases:String,
        fiscalyear:String,
        technicianName:String


    ) =  safeApiCall {
        api.postVaccine(VaccinePost(farmFarmerName,earTagNo,animalName,
                mobileNo,species,breed,vaccineName,vaccineDate,
                vaccineforDiseases,fiscalyear,technicianName))
    }

}
