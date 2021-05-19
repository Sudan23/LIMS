package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.network.RemoteDataSource.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:FarmFarmerRegistrationApi by lazy {
        retrofit.create(FarmFarmerRegistrationApi::class.java)
    }
}