package np.com.sudan10.lims_v30.data.repository

import np.com.sudan10.lims_v30.data.network.MenuApi
import np.com.sudan10.lims_v30.data.responses.User

class HomeMenuRepository(
    private val api: MenuApi
) : BaseRepository() {

    suspend fun login (
        email: String,
        password: String
    ) = safeApiCall {
        api.login(User(email, password))
    }

}
