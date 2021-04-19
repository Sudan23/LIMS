package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.CullingApi
import np.com.sudan10.lims_v30.data.network.MilkRecordingApi

class MilkRecordingRepository(
        private val api: MilkRecordingApi
) : BaseRepository()  {

}
