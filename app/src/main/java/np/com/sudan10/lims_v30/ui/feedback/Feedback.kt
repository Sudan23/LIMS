package np.com.sudan10.lims_v30.ui.feedback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.databinding.FragmentFeedbackBinding


class Feedback : Fragment() {
    
    private lateinit var feedbackViewModel: FeedbackViewModel
    private lateinit var viewModel: FeedbackViewModel
    private var _binding: FragmentFeedbackBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentFeedbackBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_feedback,container,false )
        val view = binding.root
        binding.lifecycleOwner = this

        val spinner: Spinner = binding.feedbackCategoryInput
        ArrayAdapter.createFromResource(
                requireContext(),
                R.array.feedback_category,android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerAdapter = adapter

        }


        return view
    }

   /* override fun onClicked() {
        ViewUtils.showMessage(requireContext(),"Feedback send clicked")    
    }

    override fun onSuccess() {
        ViewUtils.showMessage(requireContext(),"Feedback send Sucessful")
    }

    override fun onFailure(message: String) {
        ViewUtils.showMessage(requireContext(),"message")

    }*/
}