package np.com.sudan10.lims_v21.repository

import np.com.sudan10.lims_v30.data.network.AuthApi
import np.com.sudan10.lims_v30.data.repository.BaseRepository
import np.com.sudan10.lims_v30.responses.User

class AuthRepository(
        private val api:AuthApi
) : BaseRepository() {

    suspend fun login (
            email: String,
            password: String
    ) = safeApiCall {
        api.login(User(email, password))
    }

}