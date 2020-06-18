package com.example.navgraphpassdata.ui.details

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.navgraphpassdata.ui.details.languages.LanguagesFragment

class ViewPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {

        0 -> TranslationsFragment()
        1 -> LanguagesFragment()
        else -> throw IllegalStateException("Invalid adapter position")
    }


}