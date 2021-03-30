package np.com.sudan10.lims_v30.ui.registration

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_farm_farmer_registration.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.AnimalRegistrationApi
import np.com.sudan10.lims_v30.data.network.FarmFarmerRegistrationApi
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.AnimRegisRepository
import np.com.sudan10.lims_v30.data.repository.FarmFarmerRegisRepository
import np.com.sudan10.lims_v30.databinding.FragmentFarmFarmerRegistrationBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class FarmRegistration : BaseFragment<FarmRegisViewModel, FragmentFarmFarmerRegistrationBinding, FarmFarmerRegisRepository>() {

    override fun onResume() {
        super.onResume()

        viewModel.farmRegisResponse.observe(viewLifecycleOwner, Observer {


            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "Thank you for Farm Registration", Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Farm Registration failed", Toast.LENGTH_SHORT).show()
                }
            }

        })

        var category:String? = null
        var name_nepali:String? = null
        var name_english:String? = null
        var type:String? = null
        var citizenshipNo:String? = null
        var pan:String? = null
        var mobileNo:String? = null
        var pprsSelection:Boolean = true

        val category_option = resources.getStringArray(R.array.farm_registration_category)
        val type_option = resources.getStringArray(R.array.farm_type)

        val spinnerCategory = fr_farm_selector_for_registration
        val spinnerType = fr_type_spinner

        if (spinnerCategory != null) {
            val adapter = ArrayAdapter<Any?>(requireContext(),
                    android.R.layout.simple_spinner_item,
                    category_option)

            spinnerCategory.adapter = adapter

            spinnerCategory.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    category = category_option[position]
                    when (category) {
                        "Farm" -> {
                            binding.frTypeTv.visibility = View.VISIBLE
                            binding.frTypeSpinner.visibility = View.VISIBLE
                            binding.frCitizenshipTv.visibility = View.GONE
                            binding.frCitizenshipEt.visibility = View.GONE
                            binding.panNoTv.visibility = View.VISIBLE
                            binding.panNoEt.visibility = View.VISIBLE
                        }
                        "Farmer" -> {
                            binding.frTypeTv.visibility = View.GONE
                            binding.frTypeSpinner.visibility = View.GONE
                            binding.frCitizenshipTv.visibility = View.VISIBLE
                            binding.frCitizenshipEt.visibility = View.VISIBLE
                            binding.panNoTv.visibility = View.GONE
                            binding.panNoEt.visibility = View.GONE
                        }
                        else -> {
                            binding.frTypeTv.visibility = View.GONE
                            binding.frTypeSpinner.visibility = View.GONE
                            binding.frCitizenshipTv.visibility = View.GONE
                            binding.frCitizenshipEt.visibility = View.GONE
                            binding.panNoTv.visibility = View.VISIBLE
                            binding.panNoEt.visibility = View.VISIBLE
                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(requireContext(),
                            "Please select the Category", Toast.LENGTH_SHORT).show()
                }
            }
        }

        if (spinnerType != null) {
            val adapter = ArrayAdapter<Any?>(requireContext(),
                    android.R.layout.simple_spinner_item,
                    type_option)

            spinnerType.adapter = adapter

            spinnerType.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    type = type_option[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(requireContext(),
                            "Please select the Type", Toast.LENGTH_SHORT).show()
                }
            }
        }




        binding.farmRegisBtn.setOnClickListener {
            name_english = binding.frNameEnglishEt.text.toString().trim()
            name_nepali = binding.frNameNepaliEt.text.toString().trim()
            citizenshipNo = binding.frCitizenshipEt.text.toString().trim()
            pan = binding.panNoEt.text.toString().trim()
            mobileNo = binding.frMobileNoEt.text.toString().trim()
            pprsSelection = !pprs_no_radiobutton.isChecked



        viewModel.farmRegis(category,citizenshipNo,
                distanceFromHighway =null, distanceFromRoad =null, district =null, drinkingWaterFacility =null, electricityFacility =null, email =null,type,
                farmerEthnicity =null, foreignJobExperience =null, houseNear100M =null,
                houseNear50M =null, latitude =null, localLevel =null, longitude =null, municipalityTaxIdentificationNumber =null,name_english,name_nepali,natureOfWork=null,pan,
                mobileNo,pprsSelection,province=null,regNo=null,registeredDate=null,roadFacility=null,tole=null,url=null,ward=null)

        }
    }




    override fun getViewModel() = FarmRegisViewModel::class.java

    override fun getFragmentBinding() = R.layout.fragment_farm_farmer_registration

    override fun getFragmentRepository(): FarmFarmerRegisRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(FarmFarmerRegistrationApi::class.java, token)
        return FarmFarmerRegisRepository(api)
    }

}