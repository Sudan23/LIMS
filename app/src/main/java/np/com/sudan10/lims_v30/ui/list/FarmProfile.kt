package np.com.sudan10.lims_v30.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.FarmFarmerRegistrationApi
import np.com.sudan10.lims_v30.data.repository.FarmFarmerRegisRepository
import np.com.sudan10.lims_v30.databinding.FragmentFarmProfileBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class FarmProfile : BaseFragment<FarmProfileViewModel, FragmentFarmProfileBinding,FarmFarmerRegisRepository>() {




    override fun getViewModel() = FarmProfileViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_farm_profile

    override fun getFragmentRepository(): FarmFarmerRegisRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(FarmFarmerRegistrationApi::class.java, token)
        return FarmFarmerRegisRepository(api)
    }
}

