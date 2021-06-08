package np.com.sudan10.lims_v30.ui.home

import androidx.lifecycle.ViewModel
import np.com.sudan10.lims_v30.data.repository.FarmListRepository

class HomeViewModel(
    private val repository: FarmListRepository

): ViewModel() {
    var testvar:String? = null
}