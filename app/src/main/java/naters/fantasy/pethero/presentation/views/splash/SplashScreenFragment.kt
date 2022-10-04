package naters.fantasy.pethero.presentation.views.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import naters.fantasy.pethero.R
import naters.fantasy.pethero.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {
    private val binding: FragmentSplashScreenBinding by lazy {
        FragmentSplashScreenBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler(Looper.getMainLooper()).postDelayed({
            view?.findNavController()?.navigate(R.id.action_splashScreenFragment_to_authenticationScreen)
        }, 3000)

        return binding.root
    }


}