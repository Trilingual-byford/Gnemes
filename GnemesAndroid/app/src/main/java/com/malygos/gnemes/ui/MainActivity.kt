package com.malygos.gnemes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.malygos.gnemes.R
import com.malygos.gnemes.ui.fragment.blanck.BlankFragment
import com.malygos.gnemes.ui.fragment.post.NewPostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newPostFragment = NewPostFragment()
        val blankFragment = BlankFragment()
        supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, newPostFragment)
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, blankFragment)
            .commit()
        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.nav_item_one -> {
                    supportFragmentManager.beginTransaction().hide(blankFragment)
                        .show(newPostFragment).commit()
                }
                R.id.nav_item_two -> {
                    supportFragmentManager.beginTransaction().hide(newPostFragment)
                        .show(blankFragment).commit()
                }
            }
            true
        }
    }
}