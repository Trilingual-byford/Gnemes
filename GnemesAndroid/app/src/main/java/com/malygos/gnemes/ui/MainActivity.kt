package com.malygos.gnemes.ui

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
        var click=false
        bottomAppBar.setOnMenuItemClickListener {
            val currentDestination = navController.currentDestination
            when(it.itemId){
                R.id.nav_item_one ->
//                    if(currentDestination?.label =="NewPostFragment"){
//                        return@setOnMenuItemClickListener true
//                    }else{
//                        navController.navigate(R.id.action_global_go_post)
//                    }
                if(!navController.popBackStack(R.id.newPostFragment,true)){
                    navController.navigate(R.id.action_global_go_blanck)
                }
                R.id.nav_item_two ->
//                    if(currentDestination?.label =="BlankFragment"){
//                        return@setOnMenuItemClickListener true
//                    }else{
                    if(!navController.popBackStack(R.id.blankFragment,true)){
                        navController.navigate(R.id.action_global_go_blanck)
                    }
//                    if(!click){
//                        navController.navigate(R.id.action_global_go_blanck)
//                        click=true
//                    }else{
//                    }

//                    }
            }
            true
        }
    }
}