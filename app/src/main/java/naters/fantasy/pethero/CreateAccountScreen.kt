package naters.fantasy.pethero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import naters.fantasy.pethero.databinding.FragmentCreateAccountScreenBinding
import naters.fantasy.pethero.databinding.FragmentHomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreateAccountScreen : Fragment() {
    private var mAuth: FirebaseAuth? = null
    private var currentUser : FirebaseUser? = null

    private val binding: FragmentCreateAccountScreenBinding by lazy {
        FragmentCreateAccountScreenBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.signupButton.setOnClickListener{
            val email = binding.inputEmailBox.text.trim()
            val password = binding.inputPasswordBox.text.trim()

        }
        return binding.root
    }

}