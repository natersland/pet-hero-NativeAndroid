package naters.fantasy.pethero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import naters.fantasy.pethero.presentation.views.LoadingScreenDialogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.button).setOnClickListener {
//            LoadingScreenDialogFragment.getInstance().show(
//                supportFragmentManager, "Loading"
//            )
//        }
    }
}