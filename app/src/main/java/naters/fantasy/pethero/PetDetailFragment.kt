package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import naters.fantasy.pethero.databinding.FragmentCreateNewPetSelectTypeBinding
import naters.fantasy.pethero.databinding.FragmentPetDetailBinding
import naters.fantasy.pethero.model.PetType

class PetDetailFragment : Fragment() {


    private val binding: FragmentPetDetailBinding by lazy {
        FragmentPetDetailBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// header zone
        binding.btnBack.setOnClickListener{view:View->
            view.findNavController().navigate(R.id.action_petDetailFragment3_to_homeScreenFragment)
        }

        val args: PetDetailFragmentArgs by navArgs()
        binding.petName.text = args.petData.petName
        binding.petPicture.setImageResource(when(args.petData.petType){
            PetType.cat -> R.drawable.catty
            else -> R.drawable.dog_1
        })
        binding.icGender.setImageResource(when(args.petData.petGender){
            "female" -> R.drawable.sex_female
            else -> R.drawable.sex_male
        })
        binding.petTypeText.text = when(args.petData.petType){
            PetType.cat -> "แมว (Cat)"
            else -> "สุนัข (Dog)"
        }
        binding.tvAgeValue.text = args.petData.petAge.toString()
        binding.tvHumanAgeValue.text = args.petData.humanAge.toString()
        binding.tvLovePointValue.text = args.petData.lovePoint.toString()
        binding.tvAboutMeValue.text = when(args.petData.aboutPet){
            "" -> "-"
            else -> args.petData.aboutPet
        }


        binding.icHeart1.setImageResource(when(args.petData.lovePoint){
            in 0..9 -> R.drawable.ic_baseline_favorite_24_gray
            else -> R.drawable.ic_baseline_favorite_24_pink
        })
        binding.icHeart2.setImageResource(when(args.petData.lovePoint){
            in 0..19 -> R.drawable.ic_baseline_favorite_24_gray
            else -> R.drawable.ic_baseline_favorite_24_pink
        })
        binding.icHeart3.setImageResource(when(args.petData.lovePoint){
            in 0..29 -> R.drawable.ic_baseline_favorite_24_gray
            else -> R.drawable.ic_baseline_favorite_24_pink
        })
        binding.icHeart4.setImageResource(when(args.petData.lovePoint){
            in 0..39 -> R.drawable.ic_baseline_favorite_24_gray
            else -> R.drawable.ic_baseline_favorite_24_pink
        })
        binding.icHeart5.setImageResource(when(args.petData.lovePoint){
            in 0..49 -> R.drawable.ic_baseline_favorite_24_gray
            else -> R.drawable.ic_baseline_favorite_24_pink
        })
        binding.icHeart6.setImageResource(when(args.petData.lovePoint){
            in 0..59 -> R.drawable.ic_baseline_favorite_24_gray
            else -> R.drawable.ic_baseline_favorite_24_pink
        })


        return binding.root
    }


}