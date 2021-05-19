package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.FarmListApi
import np.com.sudan10.lims_v30.data.network.RetrofitInstance.api
import np.com.sudan10.lims_v30.data.responses.FarmRegistrationPost

class FarmListRepository(
    private val api: FarmListApi
) :BaseRepository(){

    suspend fun getFarmList() = safeApiCall {
        api.getFarmListing()
    }


}
