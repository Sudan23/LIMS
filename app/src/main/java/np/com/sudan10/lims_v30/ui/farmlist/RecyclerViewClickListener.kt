package np.com.sudan10.lims_v30.ui.farmlist

import android.view.View
import np.com.sudan10.lims_v30.data.responses.listing.ListFarm

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, list_farm: ListFarm)
}