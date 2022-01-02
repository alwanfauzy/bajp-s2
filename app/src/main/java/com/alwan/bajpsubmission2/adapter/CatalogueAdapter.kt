package com.alwan.bajpsubmission2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alwan.bajpsubmission2.R
import com.alwan.bajpsubmission2.data.model.Catalogue
import com.alwan.bajpsubmission2.databinding.ItemCatalogueBinding

class CatalogueAdapter(private val callback: CatalogueCallback) :
    RecyclerView.Adapter<CatalogueAdapter.CatalogueViewHolder>() {
    private val listCatalogue = ArrayList<Catalogue>()

    fun setCatalogue(catalogues: ArrayList<Catalogue>?) {
        if (catalogues == null) return
        listCatalogue.clear()
        listCatalogue.addAll(catalogues)
    }

    interface CatalogueCallback {
        fun onCatalogueClick(catalogue: Catalogue)
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
        fun bind(catalogue: Catalogue) {
            with(binding) {
                tvTitleCatalogue.text = catalogue.title
                tvGenreCatalogue.text = catalogue.genre
                tvScoreCatalogue.text = catalogue.score
                catalogue.poster?.let { imgPosterCatalogue.setImageResource(it) }
                    ?: imgPosterCatalogue.setImageResource(
                        R.drawable.catalogue_placeholder
                    )
                root.setOnClickListener { callback.onCatalogueClick(catalogue) }
            }
        }
    }
}