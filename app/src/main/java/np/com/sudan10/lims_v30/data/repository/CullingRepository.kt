package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.AnimalRegistrationApi
import np.com.sudan10.lims_v30.data.network.CullingApi
import np.com.sudan10.lims_v30.data.repository.BaseRepository
import np.com.sudan10.lims_v30.data.responses.AnimalRegistrationPost

class CullingRepository(
        private val api: CullingApi
) : BaseRepository() {


}