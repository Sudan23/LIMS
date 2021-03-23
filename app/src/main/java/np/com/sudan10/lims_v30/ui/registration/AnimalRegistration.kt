package np.com.sudan10.lims_v30.ui.registration

import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.network.Resource
import np.com.sudan10.lims_v30.data.repository.AnimRegisRepository
import np.com.sudan10.lims_v30.databinding.FragmentAnimalRegistrationBinding
import np.com.sudan10.lims_v30.ui.base.BaseFragment


class AnimalRegistration : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_animal_registration, container, false)
}


}