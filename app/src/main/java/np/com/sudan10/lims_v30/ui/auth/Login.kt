package np.com.sudan10.lims_v30.ui.auth


import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import androidx.lifecycle.Observer
import np.com.sudan10.lims_v30.data.repository.AuthRepository
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.AuthApi
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.databinding.FragmentLoginBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class Login : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {


            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_SHORT).show()
                }
            }

        })

        binding.login.setOnClickListener {
            val email = binding.usernameInput.text.toString().trim()
            val unencoded_password = binding.passwordInput.text.toString().trim()

            val byteA = unencoded_password.toByteArray()
            val password = Base64.encodeToString(byteA, Base64.DEFAULT)
            //@todo add input validations

            viewModel.login(email,password)

            }


    }


    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_login

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
    }