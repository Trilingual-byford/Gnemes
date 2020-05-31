package com.malygos.gnemes.ui.fragment.featured

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.malygos.gnemes.R
import com.malygos.gnemes.ui.fragment.LastPostFragment
import com.malygos.gnemes.ui.fragment.post.NewPostFragment
import kotlinx.android.synthetic.main.fragment_featured.*


/**
 * A simple [Fragment] subclass.
 * Use the [FeaturedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeaturedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_featured, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabFragments = getTabFragments()
        feature_view_pager.adapter=object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return tabFragments[position]
            }
            override fun getItemCount(): Int {
                return tabFragments.size
            }
        }
        val tabLayoutMediator =
            TabLayoutMediator(tab_layout, feature_view_pager, true,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                  when(position){
                      0->
                          tab.text="Recommended"
                      1->
                          tab.text="Latest"

                  }
                }).attach()

    }
    private fun getTabFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>(3)
        val newPostFragment = NewPostFragment.newInstance()
        val lastPostFragment = LastPostFragment.newInstance()
        fragments.add(newPostFragment)
        fragments.add(lastPostFragment)
        return fragments
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeaturedFragment()
    }
}