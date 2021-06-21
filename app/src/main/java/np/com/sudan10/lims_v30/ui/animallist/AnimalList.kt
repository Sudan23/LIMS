package np.com.sudan10.lims_v30.ui.animallist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.FarmListApi
import np.com.sudan10.lims_v30.data.repository.AnimalListRepository
import np.com.sudan10.lims_v30.data.repository.FarmListRepository
import np.com.sudan10.lims_v30.databinding.FragmentAnimalListBinding
import np.com.sudan10.lims_v30.databinding.FragmentFarmListingBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import np.com.sudan10.lims_v30.ui.farmlist.FarmViewModel

class AnimalList : BaseFragment<AnimalListViewModel, FragmentAnimalListBinding, AnimalListRepository>() {


    override fun getViewModel() = AnimalListViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_animal_list

    override fun getFragmentRepository() = AnimalListRepository(remoteDataSource.buildApi(FarmListApi::class.java))

}