package np.com.sudan10.lims_v30.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    companion object{
        const val BASE_URL = "http://103.69.126.198/"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ) :Api{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
    }

}