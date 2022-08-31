package naters.fantasy.pethero

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import naters.fantasy.pethero.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance("https://pet-hero-a7506-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
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