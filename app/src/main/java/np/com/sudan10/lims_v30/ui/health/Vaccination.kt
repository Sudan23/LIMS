package np.com.sudan10.lims_v30.ui.health

import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.VaccineApi
import np.com.sudan10.lims_v30.data.repository.VaccinationRepository
import np.com.sudan10.lims_v30.databinding.FragmentVaccinationBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class Vaccination : BaseFragment<VaccinationViewModel, FragmentVaccinationBinding, VaccinationRepository>() {


    override fun onResume() {
        super.onResume()





    }




    override fun getViewModel() = VaccinationViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_vaccination

    override fun getFragmentRepository() = VaccinationRepository(remoteDataSource.buildApi(VaccineApi::class.java))


}