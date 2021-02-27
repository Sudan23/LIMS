package np.com.sudan10.lims_v30.util

import android.content.Context
import android.widget.Toast


object ViewUtils {
    fun showMessage(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}