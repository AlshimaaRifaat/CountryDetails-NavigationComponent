package com.example.navgraphpassdata.ui.details

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.navgraphpassdata.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_details.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment() {
    var countryName: String? = null
    private var countryFlag: String? = null
    var timeZon: ArrayList<String>? = null
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryName = arguments?.getString("countryName")
        countryFlag = arguments?.getString("countryFlag")
        timeZon = arguments?.getStringArrayList("timeZone")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("corn", "" + countryName)

        country_text.text = countryName
        timeZon?.forEach {
            timeZone.text = it
        }

      /*  SvgLoader.pluck()
            .with(context as Activity?)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(countryFlag, flag_img)*/

     viewPagerAdapter = ViewPagerAdapter(this)
        pager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> tab.text = "Translation"
                1 -> tab.text = "Languages"
            }

        }.attach()
    }
}
