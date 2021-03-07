package com.example.modernfoodrecipesapp.ui.fragments.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modernfoodrecipesapp.R
import com.example.modernfoodrecipesapp.adapters.FavoriteRecipesAdapter
import com.example.modernfoodrecipesapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorite.view.*
import kotlinx.android.synthetic.main.fragment_recipes.view.*

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private val mAdapter: FavoriteRecipesAdapter by lazy { FavoriteRecipesAdapter() }
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        setupRecyclerView(view.favoriteRecipesRecyclerView)

        mainViewModel.readFavoriteRecipes.observe(
            viewLifecycleOwner,
            { favoritesEntity ->
                mAdapter.setData(favoritesEntity)
            }
        )

        return view
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
