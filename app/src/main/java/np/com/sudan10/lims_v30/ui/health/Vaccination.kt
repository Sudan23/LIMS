package np.com.sudan10.lims_v30.ui.health

import android.app.DatePickerDialog
import kotlinx.android.synthetic.main.fragment_culling.*
import kotlinx.android.synthetic.main.fragment_vaccination_v3.*
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.VaccineApi
import np.com.sudan10.lims_v30.data.repository.VaccinationRepository
import np.com.sudan10.lims_v30.databinding.FragmentAiNewV3Binding
import np.com.sudan10.lims_v30.databinding.FragmentVaccinationV3Binding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import java.util.*


class Vaccination : BaseFragment<VaccinationViewModel, FragmentVaccinationV3Binding, VaccinationRepository>() {


    override fun onResume() {
        super.onResume()

        binding.vaccineDate.setOnClickListener {
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
                vaccine_date.setText("$dayOfMonth $monthInput, $year")
            }, yr, month, day)
            display.datePicker.minDate = System.currentTimeMillis()
            display.show()
        }


    }




    override fun getViewModel() = VaccinationViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_vaccination_v3

    override fun getFragmentRepository() = VaccinationRepository(remoteDataSource.buildApi(VaccineApi::class.java))


}