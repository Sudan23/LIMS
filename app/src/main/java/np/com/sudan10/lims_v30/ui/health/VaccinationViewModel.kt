package np.com.sudan10.lims_v30.ui.health

import androidx.lifecycle.ViewModel
import np.com.sudan10.lims_v30.data.repository.VaccinationRepository

class VaccinationViewModel(
    private val repository: VaccinationRepository
) : ViewModel(){
    var earTag: Int? = null


}
