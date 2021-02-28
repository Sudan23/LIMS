package np.com.sudan10.lims_v30.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import np.com.sudan10.lims_v21.repository.LoginRepository

class LoginViewModelFactory(
    private val repository: LoginRepository
    ) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
        }

}