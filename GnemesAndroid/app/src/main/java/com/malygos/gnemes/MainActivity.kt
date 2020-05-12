package com.malygos.gnemes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this, R.id.fragment_container)
//        navController.navigate()
        bottomAppBar.setOnMenuItemClickListener {
            Log.v(it.itemId.toString(),"setOnMenuItemClickListener")
//            navController.
            true
        }
    }
}