package np.com.sudan10.lims_v30.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import np.com.sudan10.lims_v21.repository.FeedbackRepository
import np.com.sudan10.lims_v30.data.repository.*
import np.com.sudan10.lims_v30.ui.auth.AuthViewModel
import np.com.sudan10.lims_v30.ui.breeding.AbortionViewModel
import np.com.sudan10.lims_v30.ui.breeding.AiViewModel
import np.com.sudan10.lims_v30.ui.breeding.PregnancyDiagnosisViewModel
import np.com.sudan10.lims_v30.ui.farmlist.FarmViewModel
import np.com.sudan10.lims_v30.ui.feedback.FeedbackViewModel
import np.com.sudan10.lims_v30.ui.health.TreatmentViewModel
import np.com.sudan10.lims_v30.ui.health.VaccinationViewModel
import np.com.sudan10.lims_v30.ui.home.HomeMenuLoggedViewModel
import np.com.sudan10.lims_v30.ui.home.HomeMenuViewModel
import np.com.sudan10.lims_v30.ui.performance_record.GrowthRecordingViewModel
import np.com.sudan10.lims_v30.ui.performance_record.MilkRecordingViewModel
import np.com.sudan10.lims_v30.ui.registration.AnimalRegistrationViewModel
import np.com.sudan10.lims_v30.ui.registration.CullingViewModel
import np.com.sudan10.lims_v30.ui.registration.FarmRegisViewModel

class ViewModelFactory(
    private val repository: BaseRepository

) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T

            modelClass.isAssignableFrom(FeedbackViewModel::class.java) -> FeedbackViewModel(
                repository as FeedbackRepository
            ) as T

            modelClass.isAssignableFrom(HomeMenuLoggedViewModel::class.java) -> HomeMenuLoggedViewModel(
                repository as HomeMenuRepository
            ) as T

            modelClass.isAssignableFrom(HomeMenuViewModel::class.java) -> HomeMenuViewModel(
                repository as HomeMenuRepository
            ) as T

            modelClass.isAssignableFrom(FarmViewModel::class.java) -> FarmViewModel(
                repository as FarmListRepository
            ) as T


            modelClass.isAssignableFrom(VaccinationViewModel::class.java) -> VaccinationViewModel(
                repository as VaccinationRepository
            ) as T

            modelClass.isAssignableFrom(TreatmentViewModel::class.java) -> TreatmentViewModel(
                repository as TreatmentRepository
            ) as T

            modelClass.isAssignableFrom(AbortionViewModel::class.java) -> AbortionViewModel(
                repository as AbortionRepository
            ) as T

            modelClass.isAssignableFrom(PregnancyDiagnosisViewModel::class.java) -> PregnancyDiagnosisViewModel(
                repository as PregnancyDiagnosisRepository
            ) as T

            modelClass.isAssignableFrom(FarmRegisViewModel::class.java) -> FarmRegisViewModel(
                repository as FarmFarmerRegisRepository
            ) as T

            modelClass.isAssignableFrom(CullingViewModel::class.java) -> CullingViewModel(repository as CullingRepository) as T

            modelClass.isAssignableFrom(GrowthRecordingViewModel::class.java) -> GrowthRecordingViewModel(
                repository as GrowthRepository
            ) as T

            modelClass.isAssignableFrom(MilkRecordingViewModel::class.java) -> MilkRecordingViewModel(
                repository as MilkRecordingRepository
            ) as T

            modelClass.isAssignableFrom(AiViewModel::class.java) -> AiViewModel(repository as AiRepository) as T

            modelClass.isAssignableFrom(AnimalRegistrationViewModel::class.java) -> AnimalRegistrationViewModel(
                repository as AnimRegisRepository
            ) as T

            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}