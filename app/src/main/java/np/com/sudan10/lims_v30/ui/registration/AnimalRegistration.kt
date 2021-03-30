package np.com.sudan10.lims_v30.ui.registration

import android.os.Build
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_animal_registration.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.AnimalRegistrationApi
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.AnimRegisRepository
import np.com.sudan10.lims_v30.databinding.FragmentAnimalRegistrationBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment
import java.time.LocalDate
import java.util.*


class AnimalRegistration : BaseFragment<AnimalRegistrationViewModel,FragmentAnimalRegistrationBinding,AnimRegisRepository>(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()

        viewModel.animalRegisResponse.observe(viewLifecycleOwner, Observer {


            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "Thank you for Animal Registration", Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Animal Registration failed", Toast.LENGTH_SHORT).show()
                }
            }

        })

        var speciesId:String? = null
        var breedType:String? = null
        val breedId:String? = null
        var farmId:String? = null
        var entryType:String? = null
        var gender:String?

        val species_option = resources.getStringArray(R.array.species_name)
        val breedType_option = resources.getStringArray(R.array.breed_type)
        val farm_option = resources.getStringArray(R.array.farm_name)
        val entry_option = resources.getStringArray(R.array.entry_type)
        val spinnerSpecies = animal_species_spinner
        val spinnerBreedType = breed_type_spinner
        val spinnerFarmName = farm_selector_for_registration
        val spinnerEntryOption = entry_type_spinner


        if (spinnerSpecies != null) {
            val adapter = ArrayAdapter<Any?>(requireContext(),
                    android.R.layout.simple_spinner_item,
                    species_option)

            spinnerSpecies.adapter = adapter

            spinnerSpecies.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    speciesId = species_option[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(requireContext(),
                            "Please select the Species", Toast.LENGTH_SHORT).show()
                }
            }
        }
        if (spinnerBreedType != null) {
            val adapter = ArrayAdapter<Any?>(requireContext(),
                    android.R.layout.simple_spinner_item,
                    breedType_option)

            spinnerBreedType.adapter = adapter

            spinnerBreedType.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    breedType = breedType_option[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(requireContext(),
                            "Please select the Species", Toast.LENGTH_SHORT).show()
                }
            }
        }
        if (spinnerFarmName != null) {
            val adapter = ArrayAdapter<Any?>(requireContext(),
                    android.R.layout.simple_spinner_item,
                    farm_option)

            spinnerFarmName.adapter = adapter

            spinnerFarmName.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    farmId = farm_option[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(requireContext(),
                            "Please select the Farm", Toast.LENGTH_SHORT).show()
                }
            }
        }
        if (spinnerEntryOption != null) {
            val adapter = ArrayAdapter<Any?>(requireContext(),
                    android.R.layout.simple_spinner_item,
                    entry_option)

            spinnerEntryOption.adapter = adapter

            spinnerEntryOption.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {

                    entryType = entry_option[position]

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                    Toast.makeText(requireContext(),
                            "Please select the Entry Option", Toast.LENGTH_SHORT).show()
                }
            }
        }


        female_radiobutton.setOnClickListener {
            binding.genderFemaleLayout.visibility = VISIBLE
        }
        male_radiobutton.setOnClickListener {
            binding.genderFemaleLayout.visibility = GONE

        }

        castrate_radiobutton.setOnClickListener {
            binding.genderFemaleLayout.visibility = GONE

        }



        binding.button.setOnClickListener() {
            val pregnancyStatus:String
            val milkingStatus:String

            val name = binding.nameEdittext.text.toString().trim()
            val earTagNo = binding.tagNoEdittext.text.toString().trim()
            val dob = binding.editTextDate.text.toString().trim()
            val sireId = binding.sireidEdittext.text.toString().trim()
            val direId = binding.direidEdittext.text.toString().trim()

            pregnancyStatus = if(pregnancy_radio_btn.isChecked) {
                "Pregnant"
            } else "Not Pregnant"

            milkingStatus = if(milking_radio_btn.isChecked) {
                "Milking"
            } else "Dry Off"

            gender = when {
                female_radiobutton.isChecked -> {
                    "Female"
                }
                male_radiobutton.isChecked -> {
                    "Male"
                }
                else -> "Castrate"
            }

            val noOfCalving = parity_edittext.text.toString().trim()

            viewModel.animalRegis(speciesId,breedId,breedType,name,farmId,earTagNo,
            gender,age = null,sireId,direId,weight=null,noOfCalving,pregnancyStatus,milkingStatus,
            pregnancyStatus,animalColor = null,dob=null,entryType)

                   }

    }

    override fun getViewModel() = AnimalRegistrationViewModel::class.java

    override fun getFragmentBinding() =  R.layout.fragment_animal_registration

    override fun getFragmentRepository(): AnimRegisRepository{
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(AnimalRegistrationApi::class.java,token)
        return AnimRegisRepository(api)

    }

}