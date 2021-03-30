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
import np.com.sudan10.lims_v30.util.enable
import np.com.sudan10.lims_v30.util.hide
import np.com.sudan10.lims_v30.util.show


class Login : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onResume() {
        super.onResume()

        binding.progressBar.hide()
        binding.login.enable(false)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {

            binding.progressBar.hide()
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        userPreferences.saveAuthToken(it.value.token)

                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_SHORT).show()
                }
            }

        })

        binding.passwordInput.addTextChangedListener {
            val email = binding.usernameInput.text.toString().trim()
            binding.login.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }

        binding.login.setOnClickListener {
            val email = binding.usernameInput.text.toString().trim()
            val unencoded_password = binding.passwordInput.text.toString().trim()

            val byteA = unencoded_password.toByteArray()
            val password = Base64.encodeToString(byteA, Base64.DEFAULT)

            binding.progressBar.show()
            viewModel.login(email,password)

        }
    }



    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_login

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
    }