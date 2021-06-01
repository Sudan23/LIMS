package np.com.sudan10.lims_v30.ui.farmlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import np.com.sudan10.lims_v30.data.repository.FarmListRepository


@HiltViewModel
class FarmViewModel(private val repository: FarmListRepository) : ViewModel() {

    val farmlists = repository.namesFlow.asLiveData()

}