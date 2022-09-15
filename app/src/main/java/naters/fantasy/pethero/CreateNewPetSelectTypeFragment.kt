package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import naters.fantasy.pethero.databinding.FragmentCreateNewPetSelectTypeBinding

class CreateNewPetSelectTypeFragment : Fragment() {

    private val binding: FragmentCreateNewPetSelectTypeBinding by lazy {
        FragmentCreateNewPetSelectTypeBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.btnBack.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_createNewPetSelectType_to_homeScreenFragment)
        }

        binding.createNewPetBtn.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_createNewPetSelectType_to_createNewPetFragment)
        }

        return binding.root
    }


}