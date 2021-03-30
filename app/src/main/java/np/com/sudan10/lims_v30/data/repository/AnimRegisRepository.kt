package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.AnimalRegistrationApi
import np.com.sudan10.lims_v30.data.responses.AnimalRegistrationPost

class AnimRegisRepository(
        private val api: AnimalRegistrationApi
) : BaseRepository(){

    suspend fun register(
            speciesId:String?,breedID:String?,breedType:String?,name:String?,farmId:String?,
            earTagNo:String?,gender:String?,age:Int?,sireId:String?,damId:String?,weight:Int?,noOfCalving:String?,pregnancyStatus:String?,
            milkStatus:String?,physicalDefect:String?,animalColor:String?,dob:String?,entryType:String?

    )= safeApiCall {
        api.animalRegister(AnimalRegistrationPost(speciesId,breedID,breedType,name,farmId,
        earTagNo,gender,age,sireId,damId,weight,noOfCalving,pregnancyStatus,
                milkStatus,physicalDefect,animalColor,dob,entryType))
    }

}
