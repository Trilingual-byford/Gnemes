package com.malygos.gnemes.ui.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
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
        bottom_navigation.setOnNavigationItemSelectedListener {
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

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        showBottomNavigation()
    }

    public fun hideBottomNavigation(afterAnimation: () -> Unit) {
        with(bottom_navigation) {
            if (visibility == View.VISIBLE) {
                animate()
                    .translationY((200).toFloat())
                    .withEndAction {
                        visibility = View.GONE
                        afterAnimation()
                    }
                    .duration = 200
            }
        }
    }

    public fun showBottomNavigation() {
        // bottom_navigation is BottomNavigationView
        with(bottom_navigation) {
            if(!isVisible){
                visibility = View.VISIBLE
                animate()
                    .translationY((0).toFloat())
                    .duration = 200
            }

        }
    }
}