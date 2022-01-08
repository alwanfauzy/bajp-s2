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
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueEntity
import com.alwan.bajpsubmission2.databinding.FragmentTvShowBinding
import com.alwan.bajpsubmission2.ui.detail.DetailActivity
import com.alwan.bajpsubmission2.utils.MarginItemDecoration
import com.alwan.bajpsubmission2.utils.ViewModelFactory

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
        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
    }

    private fun setupAdapterMovie() {
        adapterTvShow = CatalogueAdapter(this)
        showLoading(true)
        tvShowViewModel.getTvShows().observe(viewLifecycleOwner, {
            adapterTvShow.setCatalogue(it)
            showLoading(false)
        })
    }

    private fun setupRvMovie() {
        with(binding.rvTvShow) {
            setHasFixedSize(true)
            addItemDecoration(MarginItemDecoration(16))
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterTvShow
        }
    }

    private fun showLoading(state: Boolean) {
        binding.progressBarTvShow.visibility = if (state) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onCatalogueClick(catalogueEntity: CatalogueEntity) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, catalogueEntity.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, 1)
        startActivity(intent)
    }
}