package np.com.sudan10.lims_v30.ui.feedback

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import np.com.sudan10.lims_v21.repository.FeedbackRepository

class FeedbackViewModelFactory(
    private val repository: FeedbackRepository
    ) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeedbackViewModel(repository) as T
        }

}