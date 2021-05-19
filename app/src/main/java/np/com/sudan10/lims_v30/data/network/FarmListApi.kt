package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.FarmListGet
import retrofit2.Response
import retrofit2.http.GET

interface FarmListApi {

    @GET("Api/Common/GetFarm")
    suspend fun getFarmList():Response<List<FarmListGet>>

    @GET("/Api/Common/GetFarm")
    suspend fun getFarmListing(): FarmListGet
}