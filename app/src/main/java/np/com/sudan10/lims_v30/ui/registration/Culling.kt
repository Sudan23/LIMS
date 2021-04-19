package np.com.sudan10.lims_v30.ui.registration

import android.app.DatePickerDialog
import kotlinx.android.synthetic.main.fragment_culling.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.CullingApi
import np.com.sudan10.lims_v30.data.repository.CullingRepository
import np.com.sudan10.lims_v30.databinding.FragmentCullingBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import java.util.*

class Culling : BaseFragment<CullingViewModel,FragmentCullingBinding, CullingRepository>() {

    override fun onResume() {
        super.onResume()
        binding.cullingDateOfCullingEt.setOnClickListener {
            val c = Calendar.getInstance()
            val yr = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val display = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener {
                view, year, monthOfYear, dayOfMonth ->
                var monthInput = (monthOfYear + 1).toString()
                if (monthInput.toInt() == 1) {
                    monthInput = "Jan"
                } else if (monthInput.toInt() == 2) {
                    monthInput = "Feb"
                } else if (monthInput.toInt() == 3) {
                    monthInput = "March"
                } else if (monthInput.toInt() == 4) {
                    monthInput = "April"
                } else if (monthInput.toInt() == 5) {
                    monthInput = "May"
                } else if (monthInput.toInt() == 6) {
                    monthInput = "June"
                } else if (monthInput.toInt() == 7) {
                    monthInput = "July"
                } else if (monthInput.toInt() == 8) {
                    monthInput = "Aug"
                } else if (monthInput.toInt() == 9) {
                    monthInput = "Sept"
                } else if (monthInput.toInt() == 10) {
                    monthInput = "Oct"
                } else if (monthInput.toInt() == 11) {
                    monthInput = "Nov"
                } else if (monthInput.toInt() == 12) {
                    monthInput = "Dec"
                }
                culling_date_of_culling_et.setText("$dayOfMonth $monthInput, $year")
            }, yr, month, day)
            display.datePicker.minDate = System.currentTimeMillis()
            display.show()
        }

    }




    override fun getViewModel() = CullingViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_culling

    override fun getFragmentRepository(): CullingRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(CullingApi::class.java, token)
        return CullingRepository(api)
    }


}