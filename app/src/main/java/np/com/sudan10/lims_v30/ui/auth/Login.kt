package np.com.sudan10.lims_v30.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_login.*
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.databinding.FragmentLoginBinding
import np.com.sudan10.lims_v30.util.ViewUtils
import np.com.sudan10.lims_v30.util.hide
import np.com.sudan10.lims_v30.util.show


class Login : Fragment(), AuthListener {

    //private lateinit var loginViewModel: AuthViewModel
    //private lateinit var viewModel: AuthViewModel

    private var _binding: FragmentLoginBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentLoginBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false )
        val view = binding.root
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        //loginViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.authListener = this

        return view

    }

    override fun onStarted() {
        progressBar.show()

    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progressBar.hide()
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })


    }

    override fun onFailure(message: String) {
        progressBar.hide()
        ViewUtils.showMessage(requireContext(),message)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}