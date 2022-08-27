package naters.fantasy.pethero

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import naters.fantasy.pethero.databinding.ActivityMainBinding
import naters.fantasy.pethero.presentation.views.LoadingScreenDialogFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
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