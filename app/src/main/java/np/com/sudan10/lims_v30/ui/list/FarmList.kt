package np.com.sudan10.lims_v30.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_farm_list.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.adapter.FarmListAdapter
import np.com.sudan10.lims_v30.data.network.FarmFarmerRegistrationApi
import np.com.sudan10.lims_v30.data.repository.FarmFarmerRegisRepository
import np.com.sudan10.lims_v30.databinding.FragmentFarmListBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class FarmList : BaseFragment<FarmListViewModel, FragmentFarmListBinding,FarmFarmerRegisRepository>() {

    private var farmList = mutableListOf<String>()
    private var addressList = mutableListOf<String>()
    private var countList = mutableListOf<String>()

    override fun onResume() {
        super.onResume()

        farmlist_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        farmlist_recyclerview.adapter = FarmListAdapter(farmList,addressList,countList)
        postToList()

    }

    private fun addToList(farmTitle:String,farmAddress:String,animalCount:String){
        farmList.add(farmTitle)
        addressList.add(farmAddress)
        countList.add(animalCount)
    }

    private fun postToList() {
        for (i in 1..25){
            addToList("Farm $i","Address $i", " $i")
        }
    }

    override fun getViewModel() = FarmListViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_farm_list

    override fun getFragmentRepository(): FarmFarmerRegisRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(FarmFarmerRegistrationApi::class.java, token)
        return FarmFarmerRegisRepository(api)
    }


}