package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.DashboardResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface DashboardApi {

    @GET("/odata/Dashboard")
    suspend fun dasboardData(): DashboardResponse
}