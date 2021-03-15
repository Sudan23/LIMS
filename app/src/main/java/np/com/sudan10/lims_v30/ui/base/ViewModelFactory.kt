package np.com.sudan10.lims_v30.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import np.com.sudan10.lims_v21.repository.AuthRepository
import np.com.sudan10.lims_v21.repository.FeedbackRepository
import np.com.sudan10.lims_v30.data.repository.BaseRepository
import np.com.sudan10.lims_v30.ui.auth.AuthViewModel
import np.com.sudan10.lims_v30.ui.feedback.FeedbackViewModel

class ViewModelFactory (
    private val repository: BaseRepository

    ): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T

            modelClass.isAssignableFrom(FeedbackViewModel::class.java) -> FeedbackViewModel(repository as FeedbackRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}