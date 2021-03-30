package np.com.sudan10.lims_v30.ui.registration

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.FarmFarmerRegisRepository
import np.com.sudan10.lims_v30.data.responses.FarmFarmerRegistrationResponse

class FarmRegisViewModel(
        private val repository: FarmFarmerRegisRepository
): ViewModel() {


    //var category:String?=null
    var citizenshipNo:String?=null
    var distanceFromHighway:String?=null
    var distanceFromRoad:String?=null
    var district:String?=null
    var drinkingWaterFacility: Boolean?=null
    var electricityFacility: Boolean?=null
    var email:String?=null
    //var farmType:String?=null
    var farmerEthnicity:String?=null
    var foreignJobExperience:Boolean?=null
    var houseNear100M:String?=null
    var houseNear50M:String?=null
    var latitude:String?=null
    var localLevel:String?=null
    var longitude:String?=null
    var municipalityTaxIdentificationNumber:String?=null
    var nameEnglish:String?=null
    var nameNepali:String?=null
    var natureOfWork:String?=null
    var panNO:String?=null
    var phone:String?=null
    var pprs:Boolean?=null
    var province:String?=null
    var regNo:String?=null
    var registeredDate:String?=null
    var roadFacility:Boolean?=null
    var tole:String?=null
    var url:String?=null
    var ward:String?=null

    private val _farmRegisResponse : MutableLiveData<Resource<FarmFarmerRegistrationResponse>> = MutableLiveData()
    val farmRegisResponse : LiveData<Resource<FarmFarmerRegistrationResponse>>
        get() = _farmRegisResponse

    var category = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }

    var farmType = ObservableField<String>().apply {
        addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("value", this@apply.get().toString()) //selected value
            }
        })
    }

    fun farmRegis(category: String?, citizenshipNo:String?, distanceFromHighway:String?, distanceFromRoad:String?, district:String?,
                  drinkingWaterFacility: Boolean?, electricityFacility: Boolean?, email:String?, farmType:String?, farmerEthnicity:String?,
                  foreignJobExperience:Boolean?, houseNear100M:String?, houseNear50M:String?, latitude:String?, localLevel:String?, longitude:String?,
                  municipalityTaxIdentificationNumber:String?, nameEnglish: String?, nameNepali: String?, natureOfWork:String?, panNO:String?, phone:String?,
                  pprs:Boolean, province:String?, regNo:String?, registeredDate:String?, roadFacility:Boolean?, tole:String?, url:String?, ward:String?

    ) = viewModelScope.launch {
        _farmRegisResponse.value = repository.registerFarm(category,citizenshipNo,distanceFromHighway,distanceFromRoad,
                district,drinkingWaterFacility,electricityFacility,email,farmType,farmerEthnicity,foreignJobExperience,houseNear100M,
                houseNear50M,latitude,localLevel,longitude,municipalityTaxIdentificationNumber,nameEnglish,nameNepali,natureOfWork,panNO,
                phone,pprs,province,regNo,registeredDate,roadFacility,tole,url,ward)
    }
}
