package np.com.sudan10.lims_v30.ui.animallist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import np.com.sudan10.lims_v30.data.repository.AnimalListRepository
import np.com.sudan10.lims_v30.data.repository.FarmListRepository

class AnimalListViewModel (private val repository: AnimalListRepository) : ViewModel() {

    val farmlists = repository.namesFlow.asLiveData()

}