package np.com.sudan10.lims_v30.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import np.com.sudan10.lims_v30.R

class LoggedInGridItemAdapter  (val cardTitles :Array<String>, val cardImages:Array<String>): RecyclerView.Adapter<LoggedInGridItemAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val cardImage : ImageView = itemView.findViewById(R.id.cardImage)
            val cardTitle : TextView = itemView.findViewById(R.id.cardTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view,parent,false)
            return ViewHolder(view)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.cardTitle.text = cardTitles[position]
            Picasso.get().load(cardImages[position]).into(holder.cardImage)

        }

        override fun getItemCount(): Int {
            return cardTitles.size
        }
    }
