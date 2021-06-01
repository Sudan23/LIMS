package np.com.sudan10.lims_v30.data.repository

import kotlinx.coroutines.flow.flow
import np.com.sudan10.lims_v30.data.network.DashboardApi

class DashboardRepository(
    private val api: DashboardApi
) : BaseRepository(){

    val dashboardFlow = flow {
        val dashboardValues = api.dasboardData()
        emit(dashboardValues)
    }
}