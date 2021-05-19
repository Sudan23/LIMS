package np.com.sudan10.lims_v30.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import np.com.sudan10.lims_v30.data.responses.listing.FarmListGet
import np.com.sudan10.lims_v30.databinding.FarmlistBinding

class FarmListAdapter :
    ListAdapter<FarmListGet, FarmListAdapter.FarmListViewHolder>(FarmListComparator()) {


    class FarmListViewHolder(private val binding: FarmlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listFarm: FarmListGet) {
            binding.apply {
                /*Glide.with(itemView)
                    .load(listFarm.logo)
                    .into(imageViewLogo)*/
                farmlistNameTv.text = listFarm.listModel.Address
                farmlistAddressTv.text = listFarm.listModel.Address
                animalIdTv.text = listFarm.listModel.Id

            }
        }

    }

    class FarmListComparator : DiffUtil.ItemCallback<FarmListGet>() {
        override fun areItemsTheSame(oldItem: FarmListGet, newItem: FarmListGet) =
            oldItem.listModel.Name == newItem.listModel.Name

        override fun areContentsTheSame(oldItem: FarmListGet, newItem: FarmListGet) =
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