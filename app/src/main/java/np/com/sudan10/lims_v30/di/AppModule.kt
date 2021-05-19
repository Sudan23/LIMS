package np.com.sudan10.lims_v30.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import np.com.sudan10.lims_v30.data.network.FarmListApi
import np.com.sudan10.lims_v30.data.network.RemoteDataSource.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideFarmListApi(retrofit: Retrofit):FarmListApi =
        retrofit.create(FarmListApi::class.java)
}