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

        // select pet type
        var petType = "cat"
        binding.catCard.setOnClickListener{
            petType = "cat"
            binding.selectedTypeCat.setVisibility(View.VISIBLE)
            binding.selectedTypeDog.setVisibility(View.INVISIBLE)
            Toast.makeText(activity,petType,Toast.LENGTH_SHORT).show()
        }
        binding.dogCard.setOnClickListener{
            petType = "dog"
            binding.selectedTypeDog.setVisibility(View.VISIBLE)
            binding.selectedTypeCat.setVisibility(View.INVISIBLE)
            Toast.makeText(activity,petType,Toast.LENGTH_SHORT).show()
        }


        binding.createNewPetBtn.setOnClickListener{view:View->
            val bundle = bundleOf("petType" to petType)
            view.findNavController().navigate(R.id.createNewPetFragment, bundle)

            view.findNavController().navigate(R.id.action_createNewPetSelectType_to_createNewPetFragment)
        }

        return binding.root
    }



}