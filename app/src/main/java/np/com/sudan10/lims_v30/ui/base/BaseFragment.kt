package np.com.sudan10.lims_v30.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.data.UserPreferences
import np.com.sudan10.lims_v30.data.network.RemoteDataSource
import np.com.sudan10.lims_v30.data.repository.BaseRepository

abstract class BaseFragment<VM: ViewModel,B: ViewDataBinding, R: BaseRepository> : Fragment(){


    protected lateinit var userPreferences: UserPreferences
    protected lateinit var binding: B
   protected lateinit var viewModel: VM

   protected val remoteDataSource = RemoteDataSource()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        userPreferences = UserPreferences(requireContext())
        binding = DataBindingUtil.inflate(
                inflater,
                getFragmentBinding(),
                container,
                false
        )
        val factory = ViewModelFactory(getFragmentRepository())

        viewModel = ViewModelProvider(this, factory).get(getViewModel())

        lifecycleScope.launch { userPreferences.authToken.first()}
        return binding.root

    }

    abstract fun getViewModel() : Class<VM>

    abstract fun getFragmentBinding(): Int

    abstract fun getFragmentRepository():R

}