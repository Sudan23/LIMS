package np.com.sudan10.lims_v30.ui.home

import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home_menu_logged_in.view.*
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.MenuApi
import np.com.sudan10.lims_v30.data.repository.HomeMenuRepository
import np.com.sudan10.lims_v30.databinding.FragmentHomeMenuBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class HomeMenu : BaseFragment<HomeMenuViewModel,FragmentHomeMenuBinding,HomeMenuRepository>() {

    override fun onResume() {
        super.onResume()

        val cardTitles : Array<String> = resources.getStringArray(R.array.cardTitles)
        val cardImages : Array<String> =  resources.getStringArray(R.array.cardImages)


        val adapter = LoggedInGridItemAdapter(cardTitles,cardImages)
        val gridLayout = GridLayoutManager(requireContext(),2)


        binding.root.gridItems.layoutManager = gridLayout
        binding.root.gridItems.adapter = adapter
    }


    override fun getViewModel() = HomeMenuViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_home_menu

    override fun getFragmentRepository() = HomeMenuRepository(remoteDataSource.buildApi(MenuApi::class.java))


}