package np.com.sudan10.lims_v30.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home_menu_logged_in.view.*
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.MenuApi
import np.com.sudan10.lims_v30.data.repository.HomeMenuRepository
import np.com.sudan10.lims_v30.databinding.FragmentHomeMenuLoggedInBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment

class HomeMenuLoggedIn : BaseFragment<HomeMenuLoggedViewModel, FragmentHomeMenuLoggedInBinding, HomeMenuRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val cardTitles : Array<String> = resources.getStringArray(R.array.cardTitles)
        val cardImages : Array<String> =  resources.getStringArray(R.array.cardImages)


        val adapter = LoggedInGridItemAdapter(cardTitles,cardImages)
        val gridLayout = GridLayoutManager(requireContext(),2)


        binding.root.gridItems.layoutManager = gridLayout
        binding.root.gridItems.adapter = adapter
    }




    override fun getViewModel() = HomeMenuLoggedViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_home_menu_logged_in

    override fun getFragmentRepository() = HomeMenuRepository(remoteDataSource.buildApi(MenuApi::class.java))
}