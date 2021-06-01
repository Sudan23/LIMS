package np.com.sudan10.lims_v30.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.responses.listing.ListFarm
import np.com.sudan10.lims_v30.databinding.FarmlistBinding
import np.com.sudan10.lims_v30.ui.farmlist.RecyclerViewClickListener

class FarmAdapter (
    private val list_farm: List<ListFarm>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<FarmAdapter.FarmViewHolder>(){

    override fun getItemCount() = list_farm.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FarmViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.farmlist,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FarmViewHolder, position: Int) {

        holder.recyclerviewFarmListBinding.farmListLayout.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewFarmListBinding.farmListLayout, list_farm[position])
        }

    }
    class FarmViewHolder(val recyclerviewFarmListBinding: FarmlistBinding) :
        RecyclerView.ViewHolder(recyclerviewFarmListBinding.root) {
        fun bind(listFarm: ListFarm) {
            recyclerviewFarmListBinding.apply {
                /*Glide.with(itemView)
                    .load(listFarm.logo)
                    .into(imageViewLogo)*/
                farmlistNameTv.text = listFarm.Name
                farmlistAddressTv.text = listFarm.Address
                animalIdTv.text = listFarm.Id

            }
        }

    }


}