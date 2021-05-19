package np.com.sudan10.lims_v30.data.network

import np.com.sudan10.lims_v30.data.responses.FarmListGet
import okhttp3.ResponseBody

sealed class Resource<out T> {

    data class Success<out T>(val value: T) : Resource<T>()

    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()

    object Loading : Resource<Nothing>()
}