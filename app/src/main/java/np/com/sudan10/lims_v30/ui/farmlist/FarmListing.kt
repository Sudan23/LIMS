package np.com.sudan10.lims_v30.ui.farmlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import np.com.sudan10.lims_v30.adapter.FarmListAdapter
import np.com.sudan10.lims_v30.databinding.FragmentFarmListBinding

class FarmListing : Fragment() {

    //private lateinit var binding: FragmentFarmListBinding
    private var _binding: FragmentFarmListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FarmListingViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFarmListBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val farmListAdapter = FarmListAdapter()

        binding.apply {

            farmlistRecyclerview.apply {
                adapter = farmListAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.farmList.observe(requireActivity()) { farmList ->
                farmListAdapter.submitList(farmList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}