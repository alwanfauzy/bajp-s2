package com.alwan.bajpsubmission2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alwan.bajpsubmission2.R
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueEntity
import com.alwan.bajpsubmission2.databinding.ItemCatalogueBinding
import com.alwan.bajpsubmission2.utils.loadImage

class CatalogueAdapter(private val callback: CatalogueCallback) :
    RecyclerView.Adapter<CatalogueAdapter.CatalogueViewHolder>() {
    private val listCatalogue = ArrayList<CatalogueEntity>()

    fun setCatalogue(catalogueEntities: ArrayList<CatalogueEntity>?) {
        listCatalogue.clear()
        catalogueEntities?.let { listCatalogue.addAll(it) }
        notifyDataSetChanged()
    }

    interface CatalogueCallback {
        fun onCatalogueClick(catalogueEntity: CatalogueEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueViewHolder {
        val itemCatalogueBinding =
            ItemCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogueViewHolder(itemCatalogueBinding)
    }

    override fun onBindViewHolder(holder: CatalogueViewHolder, position: Int) {
        holder.bind(listCatalogue[position])
    }

    override fun getItemCount(): Int = listCatalogue.size

    inner class CatalogueViewHolder(private val binding: ItemCatalogueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogue: CatalogueEntity) {
            with(binding) {
                tvTitleCatalogue.text = catalogue.name
                tvScoreCatalogue.text = catalogue.voteAverage.toString()
                catalogue.posterPath?.let { imgPosterCatalogue.loadImage(it) }
                    ?: imgPosterCatalogue.setImageResource(
                        R.drawable.catalogue_placeholder
                    )
                root.setOnClickListener { callback.onCatalogueClick(catalogue) }
            }
        }
    }
}