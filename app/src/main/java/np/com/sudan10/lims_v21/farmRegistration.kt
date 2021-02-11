package np.com.sudan10.lims_v21

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_commonregistration.*

class farmRegistration : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_farm_registration, container, false)

        // Inflate the layout for this fragment
        /*var view: View = inflater!!.inflate(R.layout.fragment_farm_registration, container, false)

        farm_next.setOnClickListener {
            val myToast = Toast.makeText(context,"Ration Balance Clicked, you will be directed to ration balance page",
                Toast.LENGTH_LONG)
            myToast.setGravity(Gravity.LEFT,200,200)
            myToast.show()        }
        return view*/
    }

}