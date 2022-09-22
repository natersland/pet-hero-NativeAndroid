package naters.fantasy.pethero

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import naters.fantasy.pethero.databinding.FragmentCreateAccountScreenBinding
import naters.fantasy.pethero.databinding.FragmentHomeScreenBinding
class CreateAccountScreen : Fragment() {


    private val binding: FragmentCreateAccountScreenBinding by lazy {
        FragmentCreateAccountScreenBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize Firebase Auth
        auth = Firebase.auth
        binding.editTextEmail

        binding.btnBack.setOnClickListener{
            it.findNavController().navigate(R.id.action_createAccountScreen_to_authenticationScreen)
        }
        binding.btnLogin.setOnClickListener{
            it.findNavController().navigate(R.id.action_createAccountScreen_to_authenticationScreen)
        }
        binding.btnCreateAccount.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val rePassword = binding.editTextRePassword.text.toString().trim()

            if(email.isEmpty()){
                Toast.makeText(activity, "กรุณาใส่ E-Mail ด้วยจ้า", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                Toast.makeText(activity, "กรุณาใส่ Password ด้วยจ้า", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (password != rePassword) {
            Toast.makeText(activity, "กรุณาใส่ Password ให้ตรงกัน", Toast.LENGTH_LONG).show()
            return@setOnClickListener
        }

            activity?.let { it1 ->
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(it1) { task ->
                        if (!task.isSuccessful) {
                            if (password.length <= 8){
                                binding.editTextPassword.error = "กรุณาใส่ Password ให้มากกว่า 8 ตัวอักษร"
                            }else {
                                Toast.makeText(activity, "Login ไม่สำเร็จ: " + task.exception!!.message,Toast.LENGTH_LONG).show()
                                binding.editTextEmail.setText("")
                                binding.editTextPassword.setText("")
                                binding.editTextRePassword.setText("")
                            }
                            println("createUserWithEmail:success")
                        } else {
                            Toast.makeText(activity, "Login สำเร็จ!",
                                Toast.LENGTH_LONG).show()
                            println("email: $email, password: $password")
                            reload(it)
                        }
                    }
            }

        }

        return binding.root
    }

    private fun reload(view: View) {
        view.findNavController().navigate(R.id.action_createAccountScreen_to_homeScreenFragment)
    }


}