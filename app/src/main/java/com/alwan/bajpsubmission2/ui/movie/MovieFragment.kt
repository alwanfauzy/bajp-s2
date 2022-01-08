package com.alwan.bajpsubmission2.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.bajpsubmission2.adapter.CatalogueAdapter
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueEntity
import com.alwan.bajpsubmission2.databinding.FragmentMovieBinding
import com.alwan.bajpsubmission2.ui.detail.DetailActivity
import com.alwan.bajpsubmission2.utils.MarginItemDecoration
import com.alwan.bajpsubmission2.utils.ViewModelFactory

class MovieFragment : Fragment(), CatalogueAdapter.CatalogueCallback {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterMovie: CatalogueAdapter
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupAdapterMovie()
        setupRvMovie()
    }

    private fun setupViewModel() {
        val factory = ViewModelFactory.getInstance()
        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
    }

    private fun setupAdapterMovie() {
        adapterMovie = CatalogueAdapter(this)
        showLoading(true)
        movieViewModel.getMovies().observe(viewLifecycleOwner, {
            adapterMovie.setCatalogue(it)
            showLoading(false)
        })
    }

    private fun setupRvMovie() {
        with(binding.rvMovie) {
            setHasFixedSize(true)
            addItemDecoration(MarginItemDecoration(16))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterMovie
        }
    }

    private fun showLoading(state: Boolean) {
        binding.progressBarMovie.visibility = if (state) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onCatalogueClick(catalogueEntity: CatalogueEntity) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, catalogueEntity.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, 0)
        startActivity(intent)
    }
}