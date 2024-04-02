package com.example.tvapp.presentation.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvapp.App
import com.example.tvapp.R
import com.example.tvapp.presentation.di.DaggerSearchTitleComponent
import com.example.tvapp.utils.daggerViewModels
import kotlinx.coroutines.flow.collectLatest


class SearchTitleFragment : Fragment(R.layout.fragment_search_title) {

    val viewModel: SearchViewModel by daggerViewModels { requireActivity() }
    private lateinit var adapter: TvMazeShowResponseAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerSearchTitleComponent
            .builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)

        recyclerView = requireView().findViewById(R.id.recycler_view)

        lifecycleScope.launchWhenStarted {
            viewModel.moviesStateFlow.collectLatest {
                adapter.setMoviesList(it)
            }
        }
        setHasOptionsMenu(true)

        adapter = TvMazeShowResponseAdapter {
            findNavController().navigate(
                SearchTitleFragmentDirections.actionSearchTitleFragmentToDetailsFragment(it)
            )
        }

        recyclerView.apply {
            setHasFixedSize(true)
            adapter = this@SearchTitleFragment.adapter
            layoutManager = GridLayoutManager(this.context, 2)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrBlank() && newText.length > 2) {
                    viewModel.searchMovies(newText)
                } else adapter.setMoviesList(emptyList())
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })
    }
}
