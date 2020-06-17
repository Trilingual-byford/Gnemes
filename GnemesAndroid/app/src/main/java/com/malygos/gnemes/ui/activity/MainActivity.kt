package com.malygos.gnemes.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.malygos.gnemes.R
import com.malygos.gnemes.ui.fragment.featured.FeaturedFragment
import com.malygos.gnemes.ui.fragment.liked.LikedFragment
import com.malygos.gnemes.ui.fragment.search.SearchFragment
import com.malygos.gnemes.ui.fragment.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabFragments = getTabFragments()

        fragment_container.adapter=object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return tabFragments[position]
            }
            override fun getItemCount(): Int {
                return tabFragments.size
            }
        }
        bottomAppBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_item_one -> {
                    fragment_container.setCurrentItem(0,true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_item_two -> {
                    fragment_container.setCurrentItem(1,true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_item_three -> {
                    fragment_container.setCurrentItem(2,true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_item_four -> {
                    fragment_container.setCurrentItem(3,true)
                    return@setOnNavigationItemSelectedListener true
                }
                else ->  return@setOnNavigationItemSelectedListener true
            }
        }
    }
    private fun getTabFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>(3)
        val featuredFragment = FeaturedFragment.newInstance()
        val searchFragment = SearchFragment.newInstance()
        val likedFragment = LikedFragment.newInstance()
        val userFragment = UserFragment.newInstance()
        fragments.add(featuredFragment)
        fragments.add(searchFragment)
        fragments.add(likedFragment)
        fragments.add(userFragment)
        return fragments
    }
}