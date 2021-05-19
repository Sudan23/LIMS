package np.com.sudan10.lims_v30.ui.farmlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.FarmListRepository
import np.com.sudan10.lims_v30.data.responses.listing.FarmListGet

class FarmListingViewModel(
    val repository: FarmListRepository)  : ViewModel(){

    private val _farmListLiveData: MutableLiveData<Resource<FarmListGet>> = MutableLiveData()
    private val mutableFarmList = MutableLiveData<List<FarmListGet>>()

    val farmList: LiveData<Resource<FarmListGet>>
        get() = _farmListLiveData
/*    val farmList: LiveData<Resource<FarmListGet>>
        get() = _farmListLiveData*/

    fun getFarmList()= viewModelScope.launch {
        _farmListLiveData.value = Resource.Loading
        _farmListLiveData.value = repository.getFarmList()

    }

}