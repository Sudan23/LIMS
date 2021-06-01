package np.com.sudan10.lims_v30.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import np.com.sudan10.lims_v30.data.responses.listing.FarmListGet
import np.com.sudan10.lims_v30.data.responses.listing.ListFarm
import np.com.sudan10.lims_v30.databinding.FarmlistBinding

class FarmListAdapter :
    ListAdapter<ListFarm, FarmListAdapter.FarmListViewHolder>(FarmListComparator()) {


    class FarmListViewHolder(private val binding: FarmlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listFarm: ListFarm) {
            binding.apply {
                /*Glide.with(itemView)
                    .load(listFarm.logo)
                    .into(imageViewLogo)*/
                farmlistNameTv.text = listFarm.Name
                farmlistAddressTv.text = listFarm.Address
                animalIdTv.text = listFarm.Id

            }
        }

    }

    class FarmListComparator : DiffUtil.ItemCallback<ListFarm>() {
        override fun areItemsTheSame(oldItem: ListFarm, newItem: ListFarm) =
            oldItem.Name == newItem.Name

        override fun areContentsTheSame(oldItem: ListFarm, newItem: ListFarm) =
            oldItem == newItem


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmListViewHolder {
        val binding =
            FarmlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FarmListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FarmListViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}