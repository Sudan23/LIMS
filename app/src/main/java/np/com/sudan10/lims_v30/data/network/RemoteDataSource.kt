package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    companion object{
        const val BASE_URL = "http://103.69.126.198/"
    }

    fun <Api> buildApi(
        api: Class<Api>,
        authToken:String? = null
    ) :Api{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                            .addInterceptor { chain ->
                                chain.proceed(chain.request().newBuilder().also {
                                    it.addHeader("Authorization", "Bearer $authToken")
                                }.build())
                            }
                            .also { client ->
                                if (BuildConfig.DEBUG) {
                                    val logging = HttpLoggingInterceptor()
                                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                                    client.addInterceptor(logging)
                                }
                            }.build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
    }

}