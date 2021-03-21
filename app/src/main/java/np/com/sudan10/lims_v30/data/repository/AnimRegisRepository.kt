package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.AnimalRegistrationApi
import np.com.sudan10.lims_v30.data.responses.AnimalRegistrationPost

class AnimRegisRepository(
        private val api: AnimalRegistrationApi
) : BaseRepository(){

    suspend fun registerAnimal(
            age:Int,
            animalColor:String,
            breedID: String,
            damId:String,
            dob:String,
            earTagNo:String,
            entryType:String,
            farmId:String,
            gender:String,
            milkStatus:String,
            name:String,
            noOfCalving:String,
            physicalDefect:String,
            pregnancyStatus:String,
            sireId:String,
            speciesId:String,
            weight:Int

    )= safeApiCall {
        api.register(AnimalRegistrationPost(age,animalColor,breedID,damId,dob,earTagNo,
                                            entryType,farmId,gender,milkStatus,name,
                                            noOfCalving,physicalDefect,
                                            pregnancyStatus,sireId,speciesId,weight))
    }

}
