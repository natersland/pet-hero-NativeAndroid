package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import naters.fantasy.pethero.databinding.FragmentCreateNewPetBinding
class CreateNewPet : Fragment() {

    private val binding: FragmentCreateNewPetBinding by lazy {
        FragmentCreateNewPetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val createNewPetBtn = binding.createNewPetBtn

        createNewPetBtn.setOnClickListener{
            createNewPet()
        }


        return binding.root
    }

    private fun createNewPet() {


        val petImage = binding.petPhotoShow
        val petName = binding.petNameEditText.text.toString()
        val petGender = when (binding.genderOptions?.checkedRadioButtonId) {
            R.id.option_female -> "female"
            else -> {
                "male"
            }
        }
        val petBirthDate = binding.editTextDate
        val aboutPet = binding.aboutPetText.text.toString()


        // Upload data to Firestore
        val pet = hashMapOf(
//            "petImage" to petImage,
            "petName" to petName,
            "petGender" to petGender,
//            "petBirthDate" to petBirthDate,
            "aboutPet" to aboutPet
        )
        val db = Firebase.firestore

        if (petName === "") {
            TODO()
        } else {
            // Add a new document with a generated ID
            db.collection("pets")
                .add(pet)
                .addOnSuccessListener { documentReference ->
                    println("DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    println("Error $e")
                }
        }

    }

    // timestamp

}