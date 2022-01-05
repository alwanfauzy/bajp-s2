package com.alwan.bajpsubmission2.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alwan.bajpsubmission2.databinding.ActivityDetailBinding
import com.alwan.bajpsubmission2.utils.ViewModelFactory
import com.alwan.bajpsubmission2.utils.loadImage

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val catalogueId = intent.getIntExtra(EXTRA_ID, 0)
        val catalogueType = intent.getIntExtra(EXTRA_TYPE, 0)
        setupViewModel()
        setupDetail(catalogueId, catalogueType)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupViewModel() {
        val factory = ViewModelFactory.getInstance()
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
    }

    private fun setupDetail(id: Int?, type: Int?) {
        showLoading(true)
        when (type) {
            0 -> {
                id?.let {
                    detailViewModel.getDetailMovie(it).observe(this, { detail ->
                        with(binding) {
                            with(detail) {
                                tvTitleDetail.text = name
                                tvGenreDetail.text = genres
                                tvOverviewDetail.text = overview
                                tvScoreDetail.text = voteAverage.toString()
                                imgPosterDetail.loadImage(posterPath!!)
                            }
                        }
                        showLoading(false)
                    })
                }
            }
            1 -> {
                id?.let {
                    detailViewModel.getDetailTvShow(it).observe(this, { detail ->
                        with(binding) {
                            with(detail) {
                                tvTitleDetail.text = name
                                tvGenreDetail.text = genres
                                tvOverviewDetail.text = overview
                                tvScoreDetail.text = voteAverage.toString()
                                imgPosterDetail.loadImage(posterPath!!)
                            }
                        }
                        showLoading(false)
                    })
                }
            }
        }
    }

    private fun showLoading(state: Boolean) {
        binding.progressBarDetail.visibility = if (state) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}