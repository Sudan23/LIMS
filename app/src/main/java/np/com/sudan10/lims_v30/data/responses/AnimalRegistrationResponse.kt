package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class AnimalRegistrationResponse(
    @SerializedName("Age")
    val age: Any,
    @SerializedName("AnimalColor")
    val animalColor: Any,
    @SerializedName("BreedId")
    val breedId: String,
    @SerializedName("DOB")
    val dOB: Any,
    @SerializedName("DamId")
    val damId: Any,
    @SerializedName("EarTagNo")
    val earTagNo: Any,
    @SerializedName("EntryType")
    val entryType: Any,
    @SerializedName("FarmId")
    val farmId: String,
    @SerializedName("Gender")
    val gender: Any,
    @SerializedName("Id")
    val id: String,
    @SerializedName("MilkStatus")
    val milkStatus: Any,
    @SerializedName("Name")
    val name: String,
    @SerializedName("NoOFCalving")
    val noOFCalving: Any,
    @SerializedName("@odata.context")
    val odataContext: String,
    @SerializedName("PhysicalDefact")
    val physicalDefact: Any,
    @SerializedName("PregencyStatus")
    val pregencyStatus: Any,
    @SerializedName("SireId")
    val sireId: Any,
    @SerializedName("SpeciesId")
    val speciesId: String,
    @SerializedName("Weight")
    val weight: Any
)