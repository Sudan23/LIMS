package np.com.sudan10.lims_v30.ui.registration

import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.AnimRegisRepository
import np.com.sudan10.lims_v30.databinding.FragmentAnimalRegistrationBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class AnimalRegistration : BaseFragment<AnimalRegistrationViewModel, FragmentAnimalRegistrationBinding, AnimRegisRepository>() {

/*
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
*/

    override fun getViewModel(): Class<AnimalRegistrationViewModel> {
        TODO("Not yet implemented")
    }

    override fun getFragmentBinding(): Int {
        TODO("Not yet implemented")
    }

    override fun getFragmentRepository(): AnimRegisRepository {
        TODO("Not yet implemented")
    }


}