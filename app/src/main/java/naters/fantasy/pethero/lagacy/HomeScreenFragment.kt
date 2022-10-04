//package naters.fantasy.pethero.lagacy
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.navigation.findNavController
//import com.example.affirmations.adapter.PetAdapter
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import naters.fantasy.pethero.databinding.FragmentHomeScreenBinding
//import naters.fantasy.pethero.model.PetData
//import naters.fantasy.pethero.model.PetType
//import com.google.firebase.Timestamp
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.ktx.auth
//import naters.fantasy.pethero.R
//
//class HomeScreenFragment : Fragment() {
//
//    private val binding: FragmentHomeScreenBinding by lazy {
//        FragmentHomeScreenBinding.inflate(layoutInflater)
//    }
//    private lateinit var auth: FirebaseAuth
//
//    private val petCollectionRef = Firebase.firestore.collection("pets").orderBy("petName")
//    private val recyclerView get() = binding.petRecyclerView
//
//    private var pets: MutableList<PetData> = mutableListOf()
////    private val recyclerView = binding.petRecyclerView
//
//    private fun retrievePets() = CoroutineScope(Dispatchers.IO).launch {
//        try {
//            petCollectionRef.get()
//                .addOnSuccessListener { result ->
//                    for (document in result) {
//                        println("${document.id} => ${document.data}")
//                        val petType = document.data["petType"]?.toString()
//                        val petName = document.data["petName"]?.toString()
//                        val petGender = document.data["petGender"].toString()
//                        val petBirthDate = document.data["petBirthDate"] as Timestamp
//                        val aboutPet = document.data["aboutPet"].toString()
//                        val lovePoint = document.data["lovePoint"].toString().toInt()
//                        val pet = PetData(
//                            petType = when (petType) {
//                                "cat" -> PetType.cat
//                                "dog" -> PetType.dog
//                                else -> PetType.cat
//                            },
//                            petName = petName ?: "",
//                            petAge = 0,
//                            petGender = petGender,
//                            petBirthDate = petBirthDate.seconds * 1000L,
//                            aboutPet = aboutPet,
//                            lovePoint = lovePoint,)
//                        pets.add(pet)
//                        println("testfantasy $pet")
//                        println("HBD $petBirthDate")
//                    }
//                    recyclerView.adapter?.notifyDataSetChanged()
//
//                }
//                .addOnFailureListener { exception ->
//                    println("Error getting documents: $exception")
//                }
//
//        } catch (e: Exception) {
//            withContext(Dispatchers.Main) {
//                Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        auth = Firebase.auth
//
//// Initialize data. (old for mockup)
//        /*val myDataset = Datasource().loadPetLists()
//
//        val recyclerView = binding.petRecyclerView
//        recyclerView.adapter = ItemAdapter(activity, myDataset)
//        // Use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true)*/
//
//        // Initialize data
//        retrievePets()
//        recyclerView.adapter = PetAdapter(activity,pets)
//        recyclerView.setHasFixedSize(true)
//
//        // create new pet btn
//        binding.addPetButton.setOnClickListener { view: View ->
//            view.findNavController()
//                .navigate(R.id.action_homeScreenFragment_to_createNewPetSelectType)
//        }
//
//
//        return binding.root
//    }
//}