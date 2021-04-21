package np.com.sudan10.lims_v30.adapter

import android.location.Address
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import np.com.sudan10.lims_v30.R

class FarmListAdapter(private var farmName:List<String>, private var farmAddress:List<String>, private var animalCount:List<String>):
        RecyclerView.Adapter<FarmListAdapter.MyViewHolder>() {
            inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

                val farmTitle: TextView = itemView.findViewById(R.id.farmlist_title_tv)
                val farmAddress: TextView = itemView.findViewById(R.id.farmlist_address_tv)
                val animalCount: TextView = itemView.findViewById(R.id.count_tv)

                init {
                    itemView.setOnClickListener {
                        val position:Int = adapterPosition
                        Toast.makeText(itemView.context, "You Clicked on item = ${position+1}", Toast.LENGTH_SHORT).show()
                    }
                }

            }


            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.farmlist, parent,false)
                return MyViewHolder(v)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.farmTitle.text = farmName[position]
                holder.farmAddress.text = farmAddress[position]
                holder.animalCount.text = animalCount[position]
                
    
            }
        
            override fun getItemCount(): Int {
                return farmName.size
            }
}