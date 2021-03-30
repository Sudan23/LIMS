package np.com.sudan10.lims_v30.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import np.com.sudan10.lims_v30.ui.auth.AuthViewModel



fun Context.toast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
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

