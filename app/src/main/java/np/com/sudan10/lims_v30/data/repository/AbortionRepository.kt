package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.AbortionApi
import np.com.sudan10.lims_v30.data.network.CullingApi

class AbortionRepository(
        private val api: AbortionApi
) : BaseRepository()  {

}
