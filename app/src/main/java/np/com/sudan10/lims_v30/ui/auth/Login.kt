package np.com.sudan10.lims_v30.ui.auth

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import np.com.sudan10.lims_v21.repository.LoginRepository
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.databinding.FragmentLoginBinding
import np.com.sudan10.lims_v30.util.ViewUtils


class Login : Fragment(), AuthListener {

    private lateinit var loginViewModel: AuthViewModel
    private lateinit var viewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentLoginBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false )
        val view = binding.root

        loginViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.loginviewmodel = loginViewModel
        binding.lifecycleOwner = this
        loginViewModel.authListener = this
        binding.login.setOnClickListener {
            val repository = LoginRepository()
            val viewModelFactory = LoginViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

            val myLoginEmail = binding.usernameInput.text.toString().trim()
            val myLoginPassword = binding.passwordInput.text.toString().trim()
            val byteA = myLoginPassword.toByteArray()
            val encodedPassword = Base64.encodeToString(byteA, Base64.DEFAULT)


            val myPost = LoginPost(myLoginEmail, encodedPassword)

            viewModel.pushLoginPost(myPost)
/*
            viewModel.myLoginResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful) {
                    Log.d("Main", response.code().toString())
                    Log.d("Main", response.message())
                    Toast.makeText(context, "Success $encodedPassword", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("Response", response.errorBody().toString())
                    Toast.makeText(context, "Failure $encodedPassword", Toast.LENGTH_SHORT).show()

                }
            })
*/
        }

        return view

    }

    override fun onStarted() {
        ViewUtils.showMessage(requireContext(),"On Started")



    }

    override fun onSuccess() {
        ViewUtils.showMessage(requireContext(),"On Success")


    }

    override fun onFailure(message: String) {
        ViewUtils.showMessage(requireContext(),message)


    }

}