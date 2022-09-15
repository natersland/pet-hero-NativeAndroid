package naters.fantasy.pethero

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import naters.fantasy.pethero.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





//        setupView()

        // Loading Animation
        /*  findViewById<Button>(R.id.button).setOnClickListener {
              LoadingScreenDialogFragment.getInstance().show(
                  supportFragmentManager, "Loading"
              )
         }*/
    }

    private fun setupView() {
        TODO("Not yet implemented")
    }
}

data class Pet(var name: String, var petAge: Int, var humanAge: Int, var petType: String)
