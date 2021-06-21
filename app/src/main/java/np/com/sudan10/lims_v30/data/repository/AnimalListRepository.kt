package np.com.sudan10.lims_v30.data.repository

import kotlinx.coroutines.flow.flow
import np.com.sudan10.lims_v30.data.network.FarmListApi

class AnimalListRepository(
    private val api: FarmListApi
    ) :BaseRepository(){

        val namesFlow = flow {
            val list = api.getFarmList()
            emit(list)
        }

}
