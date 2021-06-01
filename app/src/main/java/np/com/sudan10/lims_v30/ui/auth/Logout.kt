package np.com.sudan10.lims_v30.ui.auth


import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.AuthApi
import np.com.sudan10.lims_v30.data.repository.AuthRepository
import np.com.sudan10.lims_v30.databinding.FragmentLogoutBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import np.com.sudan10.lims_v30.ui.home.Home
import np.com.sudan10.lims_v30.util.startNewActivity


class Logout : BaseFragment<AuthViewModel, FragmentLogoutBinding, AuthRepository>() {

    override fun onResume() {
        super.onResume()

        fun performLogout() = lifecycleScope.launch {
            userPreferences.clear()
            requireActivity().startNewActivity(Home::class.java)
        }

        performLogout()


    }



    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_logout

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
    }