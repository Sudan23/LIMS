package np.com.sudan10.lims_v30.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import np.com.sudan10.lims_v30.data.repository.DashboardRepository

class DashboardViewModel(
    private val repository: DashboardRepository
) : ViewModel() {
    val dashboardValues = repository.dashboardFlow.asLiveData()
}