package com.malygos.gnemes.ui.fragment.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.malygos.gnemes.R

class LoginActivity: AppCompatActivity() {
    companion object{
        fun startLoginActivity(context: Context,msg:String){
            if(context is Activity){
            val intent=Intent(context,LoginActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        setContentView(R.layout.activity_login)
        return super.onCreateView(name, context, attrs)
    }


}