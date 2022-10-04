package naters.fantasy.pethero

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import naters.fantasy.pethero.databinding.FragmentAuthenticationScreenBinding
import naters.fantasy.pethero.databinding.FragmentHomeScreenBinding
class AuthenticationScreen : Fragment() {

    private val binding: FragmentAuthenticationScreenBinding by lazy {
        FragmentAuthenticationScreenBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth

    binding.btnRegister.setOnClickListener{
        it.findNavController().navigate(R.id.action_authenticationScreen_to_createAccountScreen)

    }
        binding.btnLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            if (email.isEmpty()){
                Toast.makeText(activity,"กรุณาใส่ E-mail",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                Toast.makeText(activity,"กรุณาใส่ Password",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            activity?.let { it1 ->
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(it1) { task ->
                        if (task.isSuccessful) {
                            println("signInWithEmail:success")
                            reload(it)
                        } else {
                            Toast.makeText(activity, "Authentication failed. ${task.exception?.message}",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
        return binding.root
    }

//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
//            reload()
//        }
//    }
    private fun reload(view: View) {
//        val it = Intent(activity, HomeScreenFragment::class.java)
//        startActivity(it)
    view.findNavController().navigate(R.id.action_authenticationScreen_to_homeScreenFragment)

}

}