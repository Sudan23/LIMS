package np.com.sudan10.lims_v30.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.ui.auth.AuthViewModel
import np.com.sudan10.lims_v30.ui.auth.Login
import np.com.sudan10.lims_v30.ui.home.Home


fun Context.toast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.snackbar(message: String, action: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}

fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}

fun View.enable(enabled: Boolean){
    isEnabled = enabled
    alpha = if(enabled) 1f else 0.4f
}

fun Fragment.logout() = lifecycleScope.launch {
    if (activity is Home) {
        (activity as Home).performLogout()
    }
}
fun Fragment.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
) {
    when {
        failure.isNetworkError -> requireView().snackbar(
            "Please check your internet connection",
            retry
        )
        failure.errorCode == 401 -> {
            if (this is Login) {
                requireView().snackbar("You've entered incorrect email or password")
            } else {
                logout()
            }
        }
        else -> {
            val error = failure.errorBody?.string().toString()
            requireView().snackbar(error)
        }
    }
}


