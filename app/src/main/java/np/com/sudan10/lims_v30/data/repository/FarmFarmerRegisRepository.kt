package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.FarmFarmerRegistrationApi
import np.com.sudan10.lims_v30.data.responses.FarmRegistrationPost

class FarmFarmerRegisRepository(
        private val api: FarmFarmerRegistrationApi
) : BaseRepository(){

    suspend fun registerFarm(
            category: String?,
            citizenshipNo: String?,
            distanceFromHighway: String?,
            distanceFromRoad: String?,
            district: String?,
            drinkingWaterFacility: Boolean?,
            electricityFacility: Boolean?,
            email: String?,
            farmType: String?,
            farmerEthnicity: String?,
            foreignJobExperience: Boolean?,
            houseNear100M: String?,
            houseNear50M: String?,
            latitude: String?,
            localLevel: String?,
            longitude: String?,
            municipalityTaxIdentificationNumber: String?,
            nameEnglish: String?,
            nameNepali: String?,
            natureOfWork: String?,
            panNO: String?,
            phone: String?,
            pprs:Boolean,
            province: String?,
            regNo: String?,
            registeredDate: String?,
            roadFacility: Boolean?,
            tole: String?,
            url: String?,
            ward: String?

    )= safeApiCall {
        api.farmRegister(FarmRegistrationPost(category,citizenshipNo,distanceFromHighway,distanceFromRoad,
                district,drinkingWaterFacility,electricityFacility,email,farmType,farmerEthnicity,
                foreignJobExperience,houseNear100M,houseNear50M,latitude,localLevel,longitude,municipalityTaxIdentificationNumber,
                nameEnglish,nameNepali,natureOfWork,panNO,phone,pprs,province,regNo,registeredDate,roadFacility,tole,
                url,ward))
    }

}
