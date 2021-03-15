package np.com.sudan10.lims_v30.ui.feedback

import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.Observer
import np.com.sudan10.lims_v21.repository.FeedbackRepository
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.FeedbackApi
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.databinding.FragmentFeedbackBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class Feedback : BaseFragment<FeedbackViewModel, FragmentFeedbackBinding, FeedbackRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.feedbackResponse.observe(viewLifecycleOwner, Observer {


            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "Thank you for your valuable feedback", Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Feedback sending failed", Toast.LENGTH_SHORT).show()
                }
            }

        })

        binding.feedbackSend.setOnClickListener {
            val fullName = binding.feedbackNameInput.text.toString().trim()
            val address = binding.feedbackAddress.text.toString().trim()
            val feedbackEmail = binding.feedbackNameInput.text.toString().trim()
            val feedbackCategory = binding.feedbackNameInput.text.toString().trim()
            val feedbackMessage = binding.feedbackNameInput.text.toString().trim()

            //@todo add input validations

            viewModel.sendFeedback(fullName, address, feedbackEmail, feedbackCategory, feedbackMessage)

        }

    }

    override fun getViewModel() = FeedbackViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_feedback

    override fun getFragmentRepository() = FeedbackRepository(remoteDataSource.buildApi(FeedbackApi::class.java))
}