package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
        val petName = binding.petNameEditText.text.toString()
        val petGender = when (binding.genderOptions?.checkedRadioButtonId) {
            R.id.option_female -> "female"
            else -> {
                "male"
            }
        }
        val petBirthDate = binding.editTextDate
        val aboutPet = binding.aboutPetText.text.toString()
        val createNewPetBtn = binding.createNewPetBtn

//        createNewPetBtn.setOnClickListener{
//            saveToFirebase(petName)
//        }

        // Create a new user with a first, middle, and last name
        val user = hashMapOf(
            "petName" to petName,
        )
        val db = Firebase.firestore

// Add a new document with a generated ID
        db.collection("pets")
            .add(user)
            .addOnSuccessListener { documentReference ->
                println("DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                println("Error $e")
            }
        return binding.root
    }

    private fun saveDataToFirebase(petName: String) {
        val petName = binding.petNameEditText.text.toString()

        val database =
            FirebaseDatabase.getInstance("https://pet-hero-a7506-default-rtdb.asia-southeast1.firebasedatabase.app/")

    }

    // timestamp

}