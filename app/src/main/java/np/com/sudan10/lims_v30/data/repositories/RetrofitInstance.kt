package np.com.sudan10.lims_v30.data.repositories

import np.com.sudan10.lims_v30.data.network.FeedbackApi
import np.com.sudan10.lims_v30.data.network.LoginApi
import np.com.sudan10.lims_v30.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val feedbackApi: FeedbackApi by lazy{
        retrofit.create(FeedbackApi::class.java)
    }
    val loginApi: LoginApi by lazy{
        retrofit.create(LoginApi::class.java)
    }
}