package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.listing.ListFarm
import retrofit2.http.GET

interface FarmListApi {

    @GET("Api/Common/GetFarm")
    suspend fun getFarmList():List<ListFarm>


}