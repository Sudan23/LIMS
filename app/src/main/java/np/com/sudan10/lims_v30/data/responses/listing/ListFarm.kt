package np.com.sudan10.lims_v30.data.responses.listing

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listoffarm")
data class ListFarm (
    val Name:String,
    val Address :String,
    @PrimaryKey val Id:String
)