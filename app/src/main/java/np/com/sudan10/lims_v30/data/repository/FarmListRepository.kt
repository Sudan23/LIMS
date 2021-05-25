package np.com.sudan10.lims_v30.data.repository

import kotlinx.coroutines.flow.flow
import np.com.sudan10.lims_v30.data.network.FarmListApi

class FarmListRepository(
    private val api: FarmListApi
) :BaseRepository(){

   /* fun getFarmList() = networkBoundResource(
        query = {

        }
    )*/
val namesFlow = flow {
    val list = api.getFarmList()
       emit(list)
   }



   /* suspend fun getFarmList() :Flow<out E> = flow{
       emit(api.getFarmList())
    }
        api.getFarmList().
*/
//

}
