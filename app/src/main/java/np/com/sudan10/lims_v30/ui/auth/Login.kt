package np.com.sudan10.lims_v30.ui.auth

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import np.com.sudan10.lims_v30.DataBinderMapperImpl
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.databinding.FragmentLoginBinding
import np.com.sudan10.lims_v30.util.ViewUtils
import np.com.sudan10.lims_v30.ui.home.Home


class Login : Fragment(), AuthListener {

    private lateinit var loginViewModel: AuthViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentLoginBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false )

        loginViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.loginviewmodel = loginViewModel
        binding.lifecycleOwner = this
        loginViewModel.authListener = this

        return binding.root

    }

    override fun onStarted() {
        ViewUtils.showMessage(requireContext(),"On Started")

        //context?.let { ViewUtils.showMessage(it,"On Started") }



    }

    override fun onSuccess() {
        ViewUtils.showMessage(requireContext(),"On Success")

    //context?.let { ViewUtils.showMessage(it,"On Success") }


    }

    override fun onFailure(message: String) {
        ViewUtils.showMessage(requireContext(),message)

        //context?.let { ViewUtils.showMessage(it,message) }


    }

}