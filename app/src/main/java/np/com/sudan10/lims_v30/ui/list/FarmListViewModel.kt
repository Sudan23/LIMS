package np.com.sudan10.lims_v30.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import np.com.sudan10.lims_v30.data.repository.FarmListRepository
import np.com.sudan10.lims_v30.data.responses.listing.FarmListGet
import retrofit2.Response

class FarmListViewModel (private val repository:FarmListRepository)
: ViewModel(){

    private val farmListLiveData = MutableLiveData<Response<List<FarmListGet>>>()
    val farmList: MutableLiveData<Response<List<FarmListGet>>> = farmListLiveData

    /*init {
        viewModelScope.launch {
            val farmList = api.getFarmList()
            delay(2000)

            farmListLiveData.value = farmList
        }    }*/



    }

