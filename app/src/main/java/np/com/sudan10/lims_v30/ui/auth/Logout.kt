package np.com.sudan10.lims_v30.ui.auth


import android.util.Base64
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.AuthApi
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.AuthRepository
import np.com.sudan10.lims_v30.databinding.FragmentLoginBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import np.com.sudan10.lims_v30.ui.home.Home
import np.com.sudan10.lims_v30.util.enable
import np.com.sudan10.lims_v30.util.hide
import np.com.sudan10.lims_v30.util.show
import np.com.sudan10.lims_v30.util.startNewActivity


class Logout : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onResume() {
        super.onResume()

        fun performLogout() = lifecycleScope.launch {
            userPreferences.clear()
            requireActivity().startNewActivity(Home::class.java)
        }

        performLogout()


    }



    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_login

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
    }