package com.alwan.bajpsubmission1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alwan.bajpsubmission1.data.model.Catalogue
import com.alwan.bajpsubmission1.databinding.ActivityDetailBinding
import com.alwan.bajpsubmission1.ui.movie.MovieViewModel
import com.alwan.bajpsubmission1.ui.tvshow.TvShowViewModel

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var catalogue: Catalogue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val catalogueId = intent.getIntExtra(EXTRA_ID, 0)
        val catalogueType = intent.getIntExtra(EXTRA_TYPE, 0)
        setupDetail(catalogueId, catalogueType)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupDetail(id: Int?, type: Int?){
        when(type){
            0 -> {
                val movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
                catalogue = movieViewModel.getDetailMovie(id!!)
            }
            1 -> {
                val tvViewModel = ViewModelProvider(this)[TvShowViewModel::class.java]
                catalogue = tvViewModel.getDetailTvShow(id!!)
            }
        }

        with(binding){
            tvTitleDetail.text = catalogue.title
            tvGenreDetail.text = catalogue.genre
            tvOverviewDetail.text = catalogue.overview
            tvScoreDetail.text = catalogue.score
            imgPosterDetail.setImageResource(catalogue.poster!!)
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}