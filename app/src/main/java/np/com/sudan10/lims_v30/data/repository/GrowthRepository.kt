package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.CullingApi
import np.com.sudan10.lims_v30.data.network.GrowthApi

class GrowthRepository(
        private val api: GrowthApi
) : BaseRepository() {

}
