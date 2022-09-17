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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import naters.fantasy.pethero.databinding.FragmentAuthenticationScreenBinding
import naters.fantasy.pethero.databinding.FragmentHomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AuthenticationScreen : Fragment() {

    private val binding: FragmentAuthenticationScreenBinding by lazy {
        FragmentAuthenticationScreenBinding.inflate(layoutInflater)
    }

   /* // Google Sign-In
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      /*  auth = Firebase.auth
        //config the Google sign-in
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("547455151198-of1ibdk8vmfktfpnjemo7dk68v290pi7.apps.googleusercontent.com")
            .requestEmail()
            .build()
*/

        // Google sign-in button
    /*    binding.googleSignInButton.setOnClickListener{
            // begin google sign in
            Log.d(TAG, "onCreate: begin Google Sign In")
        }*/

        return binding.root
    }

    private fun checkUser() {
        TODO("Not yet implemented")
    }

}