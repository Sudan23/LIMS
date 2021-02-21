package np.com.sudan10.lims_v21

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast


class Ruminant_rb : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ruminant, container, false)
        val spinnerAnimalType: Spinner = view.findViewById(R.id.animaltype_spinner)
        val spinnerItems = resources.getStringArray(R.array.animal_name)
        spinnerAnimalType.adapter = ArrayAdapter<String>(
            activity?.baseContext!!,
            android.R.layout.simple_spinner_dropdown_item,
            spinnerItems
        )
        spinnerAnimalType?.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Log.i("Test", "Hello")
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinnerValue = parent?.getItemAtPosition(position).toString()
                    Log.i("Test", spinnerValue)
                    Toast.makeText(activity?.baseContext!!, spinnerValue, Toast.LENGTH_LONG).show()
                }
            }
        return view
    }

}