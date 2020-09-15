package com.malygos.gnemes.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.malygos.gnemes.R

class LoginDialogFragment:DialogFragment() {
    companion object{
        fun startLoginFragment(fragmentManager: FragmentManager,msg:String){
            val loginDialogFragment = LoginDialogFragment()
//            loginDialogFragment
            loginDialogFragment.show(fragmentManager,msg)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullscreenDialogTheme);

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        return view
    }
}