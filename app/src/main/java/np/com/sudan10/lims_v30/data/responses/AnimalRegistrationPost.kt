package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class AnimalRegistrationPost(
        @SerializedName("SpeciesId")
        val speciesId: String?,
        @SerializedName("BreedId")
        val breedId: String?,
        @SerializedName("BreedType")
        val breedType: String?,
        @SerializedName("Name")
        val name: String?,
        @SerializedName("FarmId")
        val farmId: String?,
        @SerializedName("EarTagNo")
        val earTagNo: String?,
        @SerializedName("Gender")
        val gender: String?,
        @SerializedName("Age")
        val age: Int?,
        @SerializedName("SireId")
        val sireId: String?,
        @SerializedName("DamId")
        val damId: String?,
        @SerializedName("Weight")
        val weight: Int?,
        @SerializedName("NoOFCalving")
        val noOFCalving: String?,
        @SerializedName("PregencyStatus")
        val pregencyStatus: String?,
        @SerializedName("MilkStatus")
        val milkStatus: String?,
        @SerializedName("PhysicalDefact")
        val physicalDefact: String?,
        @SerializedName("AnimalColor")
        val animalColor: String?,
        @SerializedName("DOB")
        val dob: String?,
        @SerializedName("EntryType")
        val entryType: String?
)