package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.CullingApi
import np.com.sudan10.lims_v30.data.network.PregnancyDiagnosisApi

class PregnancyDiagnosisRepository (
        private val api: PregnancyDiagnosisApi
) : BaseRepository() {

}
