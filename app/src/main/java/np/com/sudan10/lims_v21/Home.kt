package np.com.sudan10.lims_v21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
     /*   val cardTitles: Array<String> = resources.getStringArray(R.array.cardTitles)
        val cardImages: Array<String> = resources.getStringArray(R.array.cardImages)
        val adapter = GridItemAdapter(cardTitles,cardImages)

        val gridLayout = GridLayoutManager(context, 2)
        gridItems.layoutManager =gridLayout
        gridItems.adapter = adapter*/


        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}