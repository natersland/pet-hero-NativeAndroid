package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.affirmations.adapter.ItemAdapter
import naters.fantasy.pethero.data.Datasource
import naters.fantasy.pethero.databinding.FragmentHomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeScreenFragment : Fragment() {

    private val binding: FragmentHomeScreenBinding by lazy {
        FragmentHomeScreenBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Initialize data.
        val myDataset = Datasource().loadPetLists()
        val recyclerView = binding.petRecyclerView
        recyclerView.adapter = ItemAdapter(this, myDataset)
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        // create new pet btn
        binding.addPetButton.setOnClickListener{ view:View ->
            view.findNavController().navigate(R.id.action_homeScreenFragment_to_createNewPetSelectType)
        }


        return binding.root
    }

}