package np.com.sudan10.lims_v30.ui.health

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_culling.*
import kotlinx.android.synthetic.main.fragment_culling.culling_date_of_culling_et
import kotlinx.android.synthetic.main.fragment_treatment.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.CullingApi
import np.com.sudan10.lims_v30.data.network.TreatmentApi
import np.com.sudan10.lims_v30.data.repository.CullingRepository
import np.com.sudan10.lims_v30.data.repository.TreatmentRepository
import np.com.sudan10.lims_v30.databinding.FragmentTreatmentBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import java.util.*


class Treatment : BaseFragment<TreatmentViewModel,FragmentTreatmentBinding, TreatmentRepository>() {

    override fun onResume() {
        super.onResume()
        binding.treatmentTreatmentdateEt.setOnClickListener {
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
                treatment_treatmentdate_et.setText("$dayOfMonth $monthInput, $year")
            }, yr, month, day)
            display.datePicker.minDate = System.currentTimeMillis()
            display.show()
        }

    }



    override fun getViewModel() = TreatmentViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_treatment
    override fun getFragmentRepository(): TreatmentRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(TreatmentApi::class.java, token)
        return TreatmentRepository(api)
    }


}