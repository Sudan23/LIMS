package np.com.sudan10.lims_v30.ui.registration

import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.AnimRegisRepository
import np.com.sudan10.lims_v30.data.responses.AnimalRegistrationResponse

class AnimalRegistrationViewModel (private val repository: AnimRegisRepository
) : ViewModel() {

    //var speciesId: String? = null
    //var breedId: String? = null
    var name: String? = null
    //var farmId: String? = null
    var earTagNo: String? = null
    var gender: String? = null
    var age: Int? = null
    var sireID: String? = null
    var damId: String? = null
    var weight: Int? = null
    var noOfCalving: String? = null
    var pregnancyStatus: String? = null
    var animalColor: String? = null
    var dob: String? = null
    //var entryType: String? = null
    var milkStatus: String? = null
    var physicalDefact: String? = null

    private val _animalRegisResponse : MutableLiveData<Resource<AnimalRegistrationResponse>> = MutableLiveData()
    val animalRegisResponse : LiveData<Resource<AnimalRegistrationResponse>>
        get() = _animalRegisResponse


    val farmId = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }

    val speciesId = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }
    val  breedType = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }
    val breedId = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }

    val entryType = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }


    fun animalRegis(
            speciesId:String?,breedID:String?,breedType:String?,name:String?,farmId:String?,
            earTagNo:String?,gender:String?,age:Int?,sireId:String?,damId:String?,weight:Int?,noOfCalving:String?,pregnancyStatus:String?,
            milkStatus:String?,physicalDefect:String?,animalColor:String?,dob:String?,entryType:String?


    ) = viewModelScope.launch {
        _animalRegisResponse.value = repository.register(speciesId,breedID,breedType,name,farmId,
                earTagNo,gender,age,sireId,damId,weight,noOfCalving,pregnancyStatus,
                milkStatus,physicalDefect,animalColor,dob,entryType)
    }


}
