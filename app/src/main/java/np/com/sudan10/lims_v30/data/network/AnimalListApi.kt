package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.listing.ListFarm
import retrofit2.http.GET

interface AnimalListApi {

    @GET("Api/Common/GetFarm")
    suspend fun getFarmList():List<ListFarm>


}