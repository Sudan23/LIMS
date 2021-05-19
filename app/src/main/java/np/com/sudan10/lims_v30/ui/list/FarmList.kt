package np.com.sudan10.lims_v30.ui.list

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.farmlist.*
import kotlinx.android.synthetic.main.fragment_farm_list.view.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.adapter.FarmListAdapter
import np.com.sudan10.lims_v30.data.network.FarmListApi
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.FarmListRepository
import np.com.sudan10.lims_v30.data.responses.listing.ListModel
import np.com.sudan10.lims_v30.databinding.FragmentFarmListBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import np.com.sudan10.lims_v30.ui.farmlist.FarmListingViewModel
import np.com.sudan10.lims_v30.util.visible


class FarmList : BaseFragment<FarmListingViewModel, FragmentFarmListBinding, FarmListRepository>() {



    override fun onResume() {
        super.onResume()


        val adapter = FarmListAdapter()
        val gridLayout = GridLayoutManager(requireContext(),1)

        binding.root.farmlist_recyclerview.layoutManager = gridLayout
        binding.root.farmlist_recyclerview.adapter = adapter

        viewModel.getFarmList()
        viewModel.farmList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    updateUI(it.value.listModel)
                }
                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }
                is Resource.Failure -> {
                    //handleApiError(it)
                }
            }
        })






    }

    private fun updateUI(list: ListModel) {
        with(binding){
            farmlist_name_tv.text = list.Name
            farmlist_address_tv.text= list.Address
            animal_id_tv.text= list.Id
        }
    }


    override fun getViewModel() = FarmListingViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_farm_list

    override fun getFragmentRepository(): FarmListRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(FarmListApi::class.java, token)
        return FarmListRepository(api)
    }


}