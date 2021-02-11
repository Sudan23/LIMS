package np.com.sudan10.lims_v21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_login.*
import np.com.sudan10.lims_v21.login


class login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        /*login.setOnClickListener {
            val username =  username.text.toString().trim()
            val password = password.text.toString().trim()

            if(username.isEmpty()){
               Toast.makeText(getContext(),"Username Required", Toast.LENGTH_SHORT).show()

            }
            if(password.isEmpty()){
                Toast.makeText(getContext(),"Password Required", Toast.LENGTH_SHORT).show()

            }


        }*/
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

}