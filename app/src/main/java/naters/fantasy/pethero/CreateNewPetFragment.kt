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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import naters.fantasy.pethero.databinding.FragmentCreateNewPetBinding
import naters.fantasy.pethero.model.PetData
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
        val petAvatar = binding.petPhotoShow
        val args: CreateNewPetFragmentArgs by navArgs()

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
            createNewPet(view, args.selectedType.toString())
        }
        return binding.root
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.petDatePicker?.text = sdf.format(myCalendar.time)
    }

    private fun createNewPet(view: View?, userPetType: String) =
        CoroutineScope(Dispatchers.IO).launch {
            val petName = binding.petNameEditText.text.toString()
            val petGender = when (binding.genderOptions.checkedRadioButtonId) {
                R.id.option_female -> "female"
                else -> {
                    "male"
                }
            }
            val petDatePicker = binding.petDatePicker?.text.toString()
            val aboutPet = binding.aboutPetEditText?.text.toString()
            val lovePoint: Int = (0..100).random()
            val petType = userPetType


            // Upload data to Firestore
            val pet = hashMapOf(
                "petName" to petName,
                "petGender" to petGender,
                "petBirthDate" to SimpleDateFormat("dd-MM-yyyy").parse(petDatePicker),
                "aboutPet" to aboutPet,
                "lovePoint" to lovePoint,
                "petType" to petType

            )


            val petCollectionRef = Firebase.firestore.collection("pets")

            try {
                if (petName.isEmpty()||
                    petGender.isEmpty() ||
                    petDatePicker.isEmpty()
                ) {

                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            activity,
                            "กรุณาใส่ชื่อสัตว์เลี้ยง / เพศ / วันเกิด",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    // Add a new document with a generated ID
                    petCollectionRef
                        .add(pet)
                        .addOnSuccessListener { documentReference ->
                            println("DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            println("Error $e")
                        }
                    withContext(Dispatchers.Main) {
                        Toast.makeText(activity, "สร้างสัตว์เลี้ยงเรียบร้อย!", Toast.LENGTH_SHORT)
                            .show()
                    }
                    view?.findNavController()
                        ?.navigate(R.id.action_createNewPetFragment_to_homeScreenFragment)
                }


            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
//                }

            }


        }
}


