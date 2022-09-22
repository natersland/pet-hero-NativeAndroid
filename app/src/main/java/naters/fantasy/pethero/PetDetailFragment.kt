package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import naters.fantasy.pethero.databinding.FragmentCreateNewPetSelectTypeBinding
import naters.fantasy.pethero.databinding.FragmentPetDetailBinding
import naters.fantasy.pethero.model.PetType

class PetDetailFragment : Fragment() {


    private val binding: FragmentPetDetailBinding by lazy {
        FragmentPetDetailBinding.inflate(layoutInflater)
    }
    private var selectedType: PetType = PetType.cat
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }


}