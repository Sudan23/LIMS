package np.com.sudan10.lims_v30.ui.home

import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home_menu_logged_in.view.*
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.UserPreferences
import np.com.sudan10.lims_v30.data.network.MenuApi
import np.com.sudan10.lims_v30.data.repository.HomeMenuRepository
import np.com.sudan10.lims_v30.databinding.FragmentHomeMenuBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class HomeMenu : BaseFragment<HomeMenuViewModel,FragmentHomeMenuBinding,HomeMenuRepository>(), LoggedInGridItemAdapter.OnItemClickListener {

    var checkloggedin = false
    override fun onResume() {
        super.onResume()

        val userPreferences = UserPreferences(requireContext())


        userPreferences.authToken.asLiveData().observe(requireActivity(),{
            if (it == null){
                checkloggedin = false
                val cardTitles : Array<String> = resources.getStringArray(R.array.cardTitles)
                val cardImages : Array<String> =  resources.getStringArray(R.array.cardImages)


                val adapter = LoggedInGridItemAdapter(cardTitles,cardImages,this)
                val gridLayout = GridLayoutManager(requireContext(),2)


                binding.root.gridItems.layoutManager = gridLayout
                binding.root.gridItems.adapter = adapter


            } else {
                checkloggedin = true

                val cardTitles: Array<String> = resources.getStringArray(R.array.cardTitlesLoggedIn)
                val cardImages: Array<String> = resources.getStringArray(R.array.cardImagesLoggedIn)


                val adapter = LoggedInGridItemAdapter(cardTitles, cardImages, this)
                val gridLayout = GridLayoutManager(requireContext(), 2)


                binding.root.gridItems.layoutManager = gridLayout
                binding.root.gridItems.adapter = adapter
            }

        })


    }

    override fun onItemClick(position: Int) {

        if (checkloggedin) {

            when (position) {
                0 -> {
                    Navigation.findNavController(binding.root).navigate(R.id.home2dashboard)

                }
                1 -> {
                    Navigation.findNavController(binding.root).navigate(R.id.home2rationabalance)

                }

                2 -> {
                    Navigation.findNavController(binding.root).navigate(R.id.home2feedback)

                }
            }
        } else {
            when (position) {
                0 -> {
                    Navigation.findNavController(binding.root).navigate(R.id.home2rationabalance)

                }
                1 -> {
                    Navigation.findNavController(binding.root).navigate(R.id.home2feedback)

                }

            }


        }
    }

    override fun getViewModel() = HomeMenuViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_home_menu

    override fun getFragmentRepository() = HomeMenuRepository(remoteDataSource.buildApi(MenuApi::class.java))


}