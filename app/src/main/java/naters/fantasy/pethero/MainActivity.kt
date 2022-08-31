package naters.fantasy.pethero

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import naters.fantasy.pethero.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Database
        val database = FirebaseDatabase.getInstance("https://pet-hero-a7506-default-rtdb.asia-southeast1.firebasedatabase.app/")
        // test database zone
        val myRef = database.getReference("pet")//.push()
        val pet1 = Pet("sfafsf",23,213,"dog")
        myRef.setValue(pet1)

        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                val value = p0.value as HashMap<*, *>
                Log.d("value: ", value.get("name").toString())
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("value: ", p0.toString())            }

        })


/*
        setupView()
*/

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
