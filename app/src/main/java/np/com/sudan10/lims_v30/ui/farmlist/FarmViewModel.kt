package np.com.sudan10.lims_v30.ui.farmlist

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.data.repository.FarmListRepository
import np.com.sudan10.lims_v30.data.responses.listing.ListFarm


@HiltViewModel
class FarmViewModel (private val repository: FarmListRepository): ViewModel(){

    val farmlists = repository.namesFlow.asLiveData()

}