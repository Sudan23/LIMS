package np.com.sudan10.lims_v21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        //ration balance
        view.rationbalance.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2rationBalance)
        }
        view.rbtxt.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2rationBalance)
        }
        //animal registration
        view.animal_registration.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2animalregistration)
        }
        view.artxt.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2animalregistration)
        }

        //animal breeding
        view.animal_breeding.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2animalbreeding)
        }
        view.abtxt.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2animalbreeding)
        }

        //animal health
        view.animal_health.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2animalhealth)
        }
        view.ahtxt.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2animalhealth)
        }

        //animal performance record
        view.performance_record.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2performancerecord)
        }
        view.prtxt.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2performancerecord)
        }

        //feedback
        view.feedback_ib.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2feedback)
        }
        view.sbtxt.setOnClickListener {Navigation.findNavController(view).navigate(R.id.home2feedback)
        }


        return view

        //Toast Message
        /* view.test1.setOnClickListener {
     val myToast = Toast.makeText(context,"Ration Balance Clicked, you will be directed to ration balance page",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.rationbalance.setOnClickListener {
     val myToast = Toast.makeText(context,"Ration Balance Clicked, you will be directed to ration balance page",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.rbtxt.setOnClickListener {
     val myToast = Toast.makeText(context,"Ration Balance Clicked, you will be directed to ration balance page",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.animal_registration.setOnClickListener {
     val myToast = Toast.makeText(context,"Animal Registration Clicked, you will be directed to Animal Registration",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.artxt.setOnClickListener {
     val myToast = Toast.makeText(context,"Animal Registration Clicked, you will be directed to Animal Registration",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.animal_health.setOnClickListener {
     val myToast = Toast.makeText(context,"Animal Health Clicked, you will be directed to Animal Health",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.ahtxt.setOnClickListener {
     val myToast = Toast.makeText(context,"Animal Health Clicked, you will be directed to Animal Health",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.animal_breeding.setOnClickListener {
     val myToast = Toast.makeText(context,"Animal Breeding Clicked, you will be directed to Animal Breeding",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.abtxt.setOnClickListener {
     val myToast = Toast.makeText(context,"Animal Health Breeding, you will be directed to Animal Breeding",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.performance_record.setOnClickListener {
     val myToast = Toast.makeText(context,"Performance record Clicked, you will be directed to Performance record",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.prtxt.setOnClickListener {
     val myToast = Toast.makeText(context,"Performance record, you will be directed to Performance record",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.static_data_entry.setOnClickListener {
     val myToast = Toast.makeText(context,"Static Data Entry Clicked, you will be directed to Static Data Entry",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
 view.sdetxt.setOnClickListener {
     val myToast = Toast.makeText(context,"Static Data Entry, you will be directed to Static Data Entry",Toast.LENGTH_LONG)
     myToast.setGravity(Gravity.LEFT,200,200)
     myToast.show()

 }
*/

        /*test1.setOnClickListener {
            val myToast = Toast.makeText(context,"toast message with gravity",Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT,200,200)
            myToast.show()        }

        return inflater.inflate(R.layout.fragment_home, container, false)*/
    }

}