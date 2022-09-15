package naters.fantasy.pethero


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import naters.fantasy.pethero.databinding.FragmentCreateNewPetBinding
import java.util.*


class CreateNewPetFragment : Fragment() {
    private val binding: FragmentCreateNewPetBinding by lazy {
        FragmentCreateNewPetBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // header zone
        binding.btnBack?.setOnClickListener{ view:View->
            view.findNavController().navigate(R.id.action_createNewPetFragment_to_createNewPetSelectType)
        }
        // set image for pet type
        val petAvatar = binding.petPhotoPreview
        when(arguments?.getString("petType")){
            "cat" -> petAvatar?.setImageResource(R.drawable.cool)
            else -> {
                petAvatar?.setImageResource(R.drawable.corgi)
            }
        }

        // create new pet
        val createNewPetBtn = binding.createNewPetBtn

        createNewPetBtn.setOnClickListener {
        }


        return binding.root
    }


    private fun createNewPet() {

        // Upload Pet Photo
        val petImagePreview = binding.petPhotoPreview
        val btnChooseImage = binding.uploadImageBtn

//        btnChooseImage.setOnClickListener{
//            launchGallery()
//        }

        // Others
        val petName = binding.petNameEditText.text.toString()
        val petGender = when (binding.genderOptions?.checkedRadioButtonId) {
            R.id.option_female -> "female"
            else -> {
                "male"
            }
        }
        var petDatePicker = binding.petDatePicker
        val aboutPet = binding.aboutPetText.text.toString()



        // Upload data to Firestore
        val pet = hashMapOf(
            "petImage" to petImagePreview,
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

    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }


    // timestamp

}


