package np.com.sudan10.lims_v30.ui.farmlist

import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.adapter.FarmListAdapter
import np.com.sudan10.lims_v30.data.network.FarmListApi
import np.com.sudan10.lims_v30.data.repository.FarmListRepository
import np.com.sudan10.lims_v30.databinding.FragmentFarmListingBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import np.com.sudan10.lims_v30.util.visible

class FarmListing :BaseFragment<FarmViewModel, FragmentFarmListingBinding,FarmListRepository>(){
    override fun onResume() {
        super.onResume()

        val farmListAdapter = FarmListAdapter()
        binding.progressbar.visible(false)


        binding.apply {

            farmlistRecyclerview.apply {
                adapter = farmListAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.farmlists.observe(requireActivity()) { farmList ->
                farmListAdapter.submitList(farmList)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object  : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.farmlist2dashboard)
            }

        })
        binding.flaotingactionbuttonAddFarm.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.farmlist2farmregister)

        }



    }




    override fun getViewModel() = FarmViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_farm_listing

    override fun getFragmentRepository() = FarmListRepository(remoteDataSource.buildApi(FarmListApi::class.java))


}