package naters.fantasy.pethero


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import naters.fantasy.pethero.databinding.FragmentCreateNewPetBinding
import java.text.SimpleDateFormat
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
        binding.btnBack?.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_createNewPetFragment_to_createNewPetSelectType)
        }
        // set image for pet type
        val args: CreateNewPetFragmentArgs by navArgs()
        val petAvatar = binding.petPhotoShow

        when (args.selectedType.toString()) {
            "cat" -> petAvatar?.setImageResource(R.drawable.cool)
            else -> {
                petAvatar?.setImageResource(R.drawable.corgi)
            }
        }

        // date picker
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }

        binding.petDatePicker?.setOnClickListener {
            activity?.let { it1 ->
                DatePickerDialog(
                    it1, datePicker,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        }


        // create new pet feat
        binding.createNewPetBtn.setOnClickListener {
            createNewPet(view)

        }
        return binding.root
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.petDatePicker?.text = sdf.format(myCalendar.time)
    }


    private fun createNewPet(view: View?) {

        val petImagePreview = binding.petPhotoPreview
        val petName = binding.petNameEditText.text.toString()
        val petGender = when (binding.genderOptions.checkedRadioButtonId) {
            R.id.option_female -> "female"
            else -> {
                "male"
            }
        }
        val petDatePicker = binding.petDatePicker?.text.toString()
        val aboutPet = binding.aboutPetText.text.toString()
        val lovePoint: Int = 0


        // Upload data to Firestore
        val pet = hashMapOf(
            "petName" to petName,
            "petGender" to petGender,
            "petBirthDate" to petDatePicker,
            "aboutPet" to aboutPet,
            "lovePoint" to lovePoint

        )
        val db = Firebase.firestore

        if (petName == "" ||
            petGender == "" ||
            petDatePicker == "") {
            Toast.makeText(activity, "กรุณาใส่ชื่อสัตว์เลี้ยง / เพศ / วันเกิด", Toast.LENGTH_SHORT).show()
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
            Toast.makeText(activity, "สร้างสัตว์เลี้ยงเรียบร้อย!", Toast.LENGTH_SHORT).show()
            view?.findNavController()?.navigate(R.id.action_createNewPetFragment_to_homeScreenFragment)

        }

    }
}


