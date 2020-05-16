package com.malygos.gnemes.ui.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.malygos.gnemes.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        )
        bottomAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.nav_item_one -> navController.navigate(
                    R.id.action_global_go_post
                )
                R.id.nav_item_two ->navController.navigate(
                    R.id.action_global_go_blanck
                )
            }
            true
        }
    }
}