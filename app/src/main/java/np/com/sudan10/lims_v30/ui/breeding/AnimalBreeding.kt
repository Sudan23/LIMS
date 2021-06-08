package np.com.sudan10.lims_v30.ui.breeding

import androidx.navigation.Navigation
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.FarmListApi
import np.com.sudan10.lims_v30.data.repository.FarmListRepository
import np.com.sudan10.lims_v30.databinding.FragmentAnimalBreedingBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import np.com.sudan10.lims_v30.ui.home.HomeViewModel


class AnimalBreeding : BaseFragment<HomeViewModel,FragmentAnimalBreedingBinding,FarmListRepository>() {

    override fun onResume() {
        super.onResume()

        binding.addAi.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.breeding_2_ai)
        }
    }



    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_animal_breeding

    override fun getFragmentRepository() = FarmListRepository(remoteDataSource.buildApi(FarmListApi::class.java))
}