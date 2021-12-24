package com.alwan.bajpsubmission1.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.bajpsubmission1.adapter.CatalogueAdapter
import com.alwan.bajpsubmission1.data.model.Catalogue
import com.alwan.bajpsubmission1.databinding.FragmentMovieBinding
import com.alwan.bajpsubmission1.ui.DetailActivity
import com.alwan.bajpsubmission1.utils.MarginItemDecoration

class MovieFragment : Fragment(), CatalogueAdapter.CatalogueCallback {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterMovie : CatalogueAdapter
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupAdapterMovie()
        setupRvMovie()
    }

    private fun setupViewModel() {
        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
    }

    private fun setupAdapterMovie(){
        adapterMovie = CatalogueAdapter(this)
        adapterMovie.setCatalogue(movieViewModel.getMovies())
    }

    private fun setupRvMovie() {
        with(binding.rvMovie){
            setHasFixedSize(true)
            addItemDecoration(MarginItemDecoration(16))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterMovie
        }
    }

    override fun onCatalogueClick(catalogue: Catalogue) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, catalogue.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, 0)
        startActivity(intent)
    }
}