package np.com.sudan10.lims_v30.ui.dashboard

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.DashboardApi
import np.com.sudan10.lims_v30.data.repository.DashboardRepository
import np.com.sudan10.lims_v30.databinding.DashboardFragmentBinding
import np.com.sudan10.lims_v30.databinding.FragmentDashboardBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment

class Dashboard : BaseFragment< DashboardViewModel, FragmentDashboardBinding, DashboardRepository>(){

    override fun onResume() {
        super.onResume()
        binding.apply {
            viewModel.dashboardValues.observe(requireActivity()){ dashboardValues ->

                dashboardFarmCount.text = dashboardValues.farmcount.toString()
                dashboardVaccineCount.text=dashboardValues.vaccinecount.toString()
                dashboardAiCount.text = dashboardValues.aicount.toString()
                dashboardHealthcheckupCount.text = dashboardValues.healthCheckupcount.toString()


            }
        }

    }




    override fun getViewModel() = DashboardViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_dashboard

    override fun getFragmentRepository(): DashboardRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(DashboardApi::class.java,token)
        return DashboardRepository(api)
    }


}