package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import naters.fantasy.pethero.databinding.FragmentCreateNewPetSelectTypeBinding

class CreateNewPetSelectType : Fragment() {

    private val binding: FragmentCreateNewPetSelectTypeBinding by lazy {
        FragmentCreateNewPetSelectTypeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
    }


}