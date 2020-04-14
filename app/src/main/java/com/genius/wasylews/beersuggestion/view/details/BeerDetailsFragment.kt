package com.genius.wasylews.beersuggestion.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.genius.wasylews.beersuggestion.R
import com.genius.wasylews.beersuggestion.databinding.FragmentBeerDetailsBinding
import com.genius.wasylews.beersuggestion.databinding.FragmentBeerListBinding
import com.genius.wasylews.beersuggestion.domain.Beer
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_beer_list.*
import javax.inject.Inject

class BeerDetailsFragment: DaggerFragment(R.layout.fragment_beer_details) {

    private lateinit var binding: FragmentBeerDetailsBinding
    private val args: BeerDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        if (view != null) {
            binding = FragmentBeerDetailsBinding.bind(view)
            binding.item = args.item
            binding.lifecycleOwner = this
        }

        setTitle(args.item.name)

        return view
    }

    private fun setTitle(title: String) {
        with (findNavController()) {
            currentDestination?.label = title
            NavigationUI.setupActionBarWithNavController(
                requireActivity() as AppCompatActivity,
                this
            )
        }
    }
}