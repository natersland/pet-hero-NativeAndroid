package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import naters.fantasy.pethero.databinding.FragmentCreateNewPetBinding
import naters.fantasy.pethero.databinding.FragmentHomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateNewPet : Fragment() {

    private val binding: FragmentCreateNewPetBinding by lazy {
        FragmentCreateNewPetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val petImage = binding.petPhotoShow
        val petName = binding.petNameEditText
        val petGender = when(binding.genderOptions?.checkedRadioButtonId){
            R.id.option_female -> "female"
            else -> { "male"}
        }
        val petBirthDate = binding.editTextDate
        val aboutPet = binding.aboutPetText


        return binding.root
    }

    // timestamp

}