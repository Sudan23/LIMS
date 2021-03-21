package np.com.sudan10.lims_v30.ui.feedback

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_feedback.*
import np.com.sudan10.lims_v21.repository.FeedbackRepository
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.FeedbackApi
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.databinding.FragmentFeedbackBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class Feedback : BaseFragment<FeedbackViewModel, FragmentFeedbackBinding, FeedbackRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var feedbackCategory:String? = null


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




        val categoryOption = resources.getStringArray(R.array.feedback_category)
        val spinner = feedback_category_input
        if (spinner != null) {
            val adapter = ArrayAdapter<Any?>(requireContext(),
                    android.R.layout.simple_spinner_item,
                    categoryOption)

            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    feedbackCategory = categoryOption[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(requireContext(),
                            "Please select the category", Toast.LENGTH_SHORT).show()
                }
            }
        }

    binding.feedbackSend.setOnClickListener {
            val fullName = binding.feedbackNameInput.text.toString().trim()
            val address = binding.feedbackAddressInput.text.toString().trim()
            val feedbackEmail = binding.feedbackEmailInput.text.toString().trim()
            val feedbackMessage = binding.feedbackMessageInput.text.toString().trim()




        viewModel.sendFeedback(fullName, address, feedbackEmail, feedbackCategory, feedbackMessage)




        }

    }

    override fun getViewModel() = FeedbackViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_feedback

    override fun getFragmentRepository() = FeedbackRepository(remoteDataSource.buildApi(FeedbackApi::class.java))
}