package com.genius.wasylews.beersuggestion.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.genius.wasylews.beersuggestion.R
import com.genius.wasylews.beersuggestion.databinding.FragmentBeerListBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_beer_list.*
import javax.inject.Inject

class BeerListFragment: DaggerFragment(R.layout.fragment_beer_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: BeerListViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentBeerListBinding

    private val adapter =  BeersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        if (view != null) {
            binding = FragmentBeerListBinding.bind(view)
            binding.lifecycleOwner = this
            binding.viewModel = viewModel
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_beer_list.adapter = adapter

        viewModel.beers.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })

        adapter.setOnItemClickListener { _, _, position ->
            val beer = adapter.getItem(position)
            val showDetailsAction = BeerListFragmentDirections.showDetails(beer)
            findNavController().navigate(showDetailsAction)
        }

        viewModel.loadData()
    }
}