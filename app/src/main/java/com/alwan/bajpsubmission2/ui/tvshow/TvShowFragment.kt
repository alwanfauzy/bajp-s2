package com.alwan.bajpsubmission2.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.bajpsubmission2.adapter.CatalogueAdapter
import com.alwan.bajpsubmission2.data.model.Catalogue
import com.alwan.bajpsubmission2.databinding.FragmentTvShowBinding
import com.alwan.bajpsubmission2.ui.DetailActivity
import com.alwan.bajpsubmission2.utils.MarginItemDecoration

class TvShowFragment : Fragment(), CatalogueAdapter.CatalogueCallback {
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterTvShow: CatalogueAdapter
    private lateinit var tvShowViewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)

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
        tvShowViewModel = ViewModelProvider(this)[TvShowViewModel::class.java]
    }

    private fun setupAdapterMovie() {
        adapterTvShow = CatalogueAdapter(this)
        adapterTvShow.setCatalogue(tvShowViewModel.getTvShows())
    }

    private fun setupRvMovie() {
        with(binding.rvTvShow) {
            setHasFixedSize(true)
            addItemDecoration(MarginItemDecoration(16))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterTvShow
        }
    }

    override fun onCatalogueClick(catalogue: Catalogue) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, catalogue.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, 1)
        startActivity(intent)
    }
}