package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.AiApi
import np.com.sudan10.lims_v30.data.responses.SubmitAidataclass

class AiRepository (
        private val api: AiApi
        ): BaseRepository(){

            suspend fun SubmitAi (
                    name:String,
                    earTagNo:String,
                    animalName:String,
                    mobileNo:String,
                    fiscalYear:String,
                    species:String,
                    breed:String,
                    aiDate:String,
                    repeatAI:String,
                    semenBullId:String,
                    semenNo:String,
                    technicianName:String
            ) =safeApiCall {
                api.SubmitAi(SubmitAidataclass(name, earTagNo,animalName,mobileNo,fiscalYear))
            }

}
