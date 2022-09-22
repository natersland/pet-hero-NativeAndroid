package naters.fantasy.pethero

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import naters.fantasy.pethero.databinding.FragmentCreateNewPetSelectTypeBinding
import naters.fantasy.pethero.model.PetType

class CreateNewPetSelectTypeFragment : Fragment() {

    private val binding: FragmentCreateNewPetSelectTypeBinding by lazy {
        FragmentCreateNewPetSelectTypeBinding.inflate(layoutInflater)
    }
    private var selectedType: PetType = PetType.cat
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // header zone
        binding.btnBack.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_createNewPetSelectType_to_homeScreenFragment)
        }
        binding.catCard.setOnClickListener{
            selectedType = PetType.cat
            binding.selectedTypeCat.visibility = View.VISIBLE
            binding.selectedTypeDog.visibility = View.INVISIBLE
        }
        binding.dogCard.setOnClickListener{
            selectedType = PetType.dog
            binding.selectedTypeDog.visibility = View.VISIBLE
            binding.selectedTypeCat.visibility = View.INVISIBLE
        }

        // Navigate btn to create new pet screen
        binding.createNewPetBtn.setOnClickListener{view:View->
            val action = CreateNewPetSelectTypeFragmentDirections.actionCreateNewPetSelectTypeToCreateNewPetFragment(selectedType)
            view.findNavController().navigate(action)

        }

        return binding.root
    }



}