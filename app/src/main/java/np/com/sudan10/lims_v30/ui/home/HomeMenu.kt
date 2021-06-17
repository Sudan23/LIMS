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

    override fun onResume() {
        super.onResume()

        val userPreferences = UserPreferences(requireContext())


        userPreferences.authToken.asLiveData().observe(requireActivity(),{
            if (it == null){
                val cardTitles : Array<String> = resources.getStringArray(R.array.cardTitles)
                val cardImages : Array<String> =  resources.getStringArray(R.array.cardImages)


                val adapter = LoggedInGridItemAdapter(cardTitles,cardImages,this)
                val gridLayout = GridLayoutManager(requireContext(),2)


                binding.root.gridItems.layoutManager = gridLayout
                binding.root.gridItems.adapter = adapter


            } else {
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

        when( position )
        {
            0 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2dashboard)

            }
            1 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2rationabalance)

            }

            3 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2feedback)

            }
        }
       /* when( position )
        {
            0 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2rationabalance)

            }
            1 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2registration)

            }
            2 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2health)

            }
            3 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2breeding)

            }
            4 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2performacerecord)

            }
            5 -> {
                Navigation.findNavController(binding.root).navigate(R.id.home2feedback)

            }
        }*/
    }

    override fun getViewModel() = HomeMenuViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_home_menu

    override fun getFragmentRepository() = HomeMenuRepository(remoteDataSource.buildApi(MenuApi::class.java))


}