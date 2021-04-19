package np.com.sudan10.lims_v30.ui.breeding

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.webkit.RenderProcessGoneDetail
import kotlinx.android.synthetic.main.fragment_culling.*
import kotlinx.android.synthetic.main.fragment_pregnancy_diagnosis_v2.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.CullingApi
import np.com.sudan10.lims_v30.data.network.PregnancyDiagnosisApi
import np.com.sudan10.lims_v30.data.repository.CullingRepository
import np.com.sudan10.lims_v30.data.repository.PregnancyDiagnosisRepository
import np.com.sudan10.lims_v30.databinding.FragmentPregnancyDiagnosisBinding
import np.com.sudan10.lims_v30.databinding.FragmentPregnancyDiagnosisV2Binding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import java.util.*

class PregnancyDiagnosis : BaseFragment<PregnancyDiagnosisViewModel, FragmentPregnancyDiagnosisV2Binding, PregnancyDiagnosisRepository>() {

    override fun onResume() {
        super.onResume()
        binding.pdDateEt.setOnClickListener {
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
                pd_date_et.setText("$dayOfMonth $monthInput, $year")
            }, yr, month, day)
            display.datePicker.minDate = System.currentTimeMillis()
            display.show()
        }

        pregnancy_yes.setOnClickListener {
            binding.pdReasonEt.visibility = GONE
            binding.pdReasonTv.visibility = GONE
        }

        pregnancy_no.setOnClickListener {
            binding.pdReasonEt.visibility = VISIBLE
            binding.pdReasonTv.visibility = VISIBLE
        }

    }


    override fun getViewModel() = PregnancyDiagnosisViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_pregnancy_diagnosis_v2

    override fun getFragmentRepository(): PregnancyDiagnosisRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(PregnancyDiagnosisApi::class.java, token)
        return PregnancyDiagnosisRepository(api)    }


}