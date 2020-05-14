package com.malygos.gnemes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import com.malygos.gnemes.network.GnemesApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.nav_item_one-> navController.navigate(R.id.action_global_go_post)
                R.id.nav_item_two->navController.navigate(R.id.action_global_go_blanck)
            }
            true
        }
        GlobalScope.launch { //no need to define Dispatchers, retrofit does that for you
            try {
                val response = GnemesApiService.getInstance().getMemePostsAsync()
                if (response.isSuccessful) {
                    //basically handle what my Deferred type is holding
                    Log.d("Scope",response.toString())
                } else {
                    //Deal with non successful response.
                    Log.d("ScopeFail", response.toString())
                }
            } catch (e: Exception) {
                //Deal with error.
                e.printStackTrace()
                Log.d("Scope", "Exception")

            }
        }
    }
}