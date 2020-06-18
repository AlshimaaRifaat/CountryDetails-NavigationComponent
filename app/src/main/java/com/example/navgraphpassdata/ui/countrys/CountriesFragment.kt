package com.example.navgraphpassdata.ui.countrys

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.navgraphpassdata.R
import com.example.navgraphpassdata.ui.MainViewModelFactory
import com.example.navgraphpassdata.utils.Progressive
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_countries.*
import kulloveth.developer.com.countrydetails.data.model.CountryDetails

/**
 * A simple [Fragment] subclass.
 */
class CountriesFragment : Fragment() ,Progressive{
    val adapter = CountrysAdapter()
    var navController: NavController? = null
    private val viewModelFactory = MainViewModelFactory()
    private lateinit var viewModel: CountrysViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(CountrysViewModel::class.java)
        viewModel.progressive= this
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        countryRv.layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
        countryRv.adapter = adapter

        initViewModel()




    }

    private fun initViewModel() {
        viewModel.loadCountryDetails().observe(requireActivity(), Observer {
            it.forEach {
                Log.d("nnnn", "" + it.name)
            }
            adapter.submitList(it)

        })
        adapter.setUpListener(object : CountrysAdapter.ItemCLickedListener {
            override fun onItemClicked(countryDetails: CountryDetails) {
                val bundle = bundleOf(
                    "countryName" to countryDetails.name,
                    "countryFlag" to countryDetails.flag,
                    "timeZone" to countryDetails.timezones
                )
               viewModel.setTranslations(countryDetails.translations)
                viewModel.setLanguages(countryDetails.language)
                navController!!.navigate(
                    R.id.action_countriesFragment_to_detailsFragment,
                    bundle
                )
                Log.d("cor", "" + countryDetails.name)

            }

        })

    }

    override fun onStarted() {
        progress.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        progress.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        progress.visibility = View.GONE
        view?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() }
    }


}
