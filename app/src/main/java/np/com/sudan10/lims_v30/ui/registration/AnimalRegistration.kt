package np.com.sudan10.lims_v30.ui.registration

import np.com.sudan10.lims_v30.data.repository.AnimRegisRepository
import np.com.sudan10.lims_v30.databinding.FragmentAnimalRegistrationBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class AnimalRegistration : BaseFragment<AnimalRegistrationViewModel, FragmentAnimalRegistrationBinding, AnimRegisRepository>() {
    override fun getViewModel(): Class<AnimalRegistrationViewModel> {
        TODO("Not yet implemented")
    }

    override fun getFragmentBinding(): Int {
        TODO("Not yet implemented")
    }

    override fun getFragmentRepository(): AnimRegisRepository {
        TODO("Not yet implemented")
    }


}