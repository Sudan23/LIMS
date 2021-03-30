package np.com.sudan10.lims_v30.ui.breeding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.AiApi
import np.com.sudan10.lims_v30.data.repository.AiRepository
import np.com.sudan10.lims_v30.databinding.FragmentAiNewV2Binding
import np.com.sudan10.lims_v30.ui.base.BaseFragment

class AI : BaseFragment<AiViewModel,FragmentAiNewV2Binding, AiRepository>() {



    override fun getViewModel() = AiViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_ai_new_v2

    override fun getFragmentRepository() = AiRepository(remoteDataSource.buildApi(AiApi::class.java))

}