package naters.fantasy.pethero.presentation.views

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import naters.fantasy.pethero.databinding.LoadingScreenPawAnimationBinding

class LoadingScreenDialogFragment: DialogFragment() {
    private lateinit var binding: LoadingScreenPawAnimationBinding


    private fun showFullScreen() {
        dialog?.let {
            val lp = WindowManager.LayoutParams()
            val window = it.window
            lp.copyFrom(window!!.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            window.attributes = lp
        }
    }

    override fun onStart() {
        super.onStart()
        showFullScreen()
    }

    override fun onResume() {
        super.onResume()
        showFullScreen()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireActivity()).apply {
            val inflater = requireActivity().layoutInflater
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            binding = LoadingScreenPawAnimationBinding.inflate(inflater, null, false)
            setContentView(binding.root)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    companion object {
        fun getInstance() = LoadingScreenDialogFragment()
    }
}