package np.com.sudan10.lims_v30.data.responses


import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("Aicount")
    val aicount: Int,
    @SerializedName("farmcount")
    val farmcount: Int,
    @SerializedName("HealthCheckupcount")
    val healthCheckupcount: Int,
    @SerializedName("Id")
    val id: Any,
    @SerializedName("PregnencyDiagnosisCount")
    val pregnencyDiagnosisCount: Int,
    @SerializedName("UserName")
    val userName: String,
    @SerializedName("vaccinecount")
    val vaccinecount: Int
)