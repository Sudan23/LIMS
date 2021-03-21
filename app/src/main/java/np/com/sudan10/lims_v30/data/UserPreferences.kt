package np.com.sudan10.lims_v30.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow


class UserPreferences {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")

        suspend fun saveToken(authToken:String) {

        }


}